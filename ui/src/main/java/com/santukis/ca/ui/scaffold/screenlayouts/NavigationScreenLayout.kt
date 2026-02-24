package com.santukis.ca.ui.scaffold.screenlayouts

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import com.santukis.ca.ui.navigation.InputArguments
import com.santukis.ca.ui.scaffold.Action
import com.santukis.ca.ui.scaffold.ScreenState
import com.santukis.ca.ui.scaffold.states.NavigationState

open class NavigationScreenLayout<
    S : ScreenState,
    US : NavigationState
    > : ScreenLayout<S, US>() {

    @Composable
    override fun Layout(
        modifier: Modifier,
        arguments: InputArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    ) {
        NavHost(
            modifier = modifier,
            navController = uiState.router.getNavController(),
            startDestination = uiState.navigationGraph.getStartDestination(),
            contentAlignment = contentAlignment(
                state = state,
                uiState = uiState
            ),
            route = route(
                state = state,
                uiState = uiState
            ),
            enterTransition = enterTransition(
                state = state,
                uiState = uiState
            ),
            exitTransition = exitTransition(
                state = state,
                uiState = uiState
            ),
            popEnterTransition = popEnterTransition(
                state = state,
                uiState = uiState
            ),
            popExitTransition = popExitTransition(
                state = state,
                uiState = uiState
            )
        ) {
            with(uiState.navigationGraph) {
                buildGraph(
                    router = uiState.router,
                    inputArguments = arguments
                )
            }
        }
    }

    protected open fun contentAlignment(
        state: S,
        uiState: US
    ): Alignment = Alignment.Center

    protected open fun route(
        state: S,
        uiState: US
    ): String? = null

    protected open fun enterTransition(
        state: S,
        uiState: US
    ): (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        { fadeIn(animationSpec = tween(TRANSITION_DURATION)) }

    protected open fun exitTransition(
        state: S,
        uiState: US
    ): (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        { fadeOut(animationSpec = tween(TRANSITION_DURATION)) }

    protected open fun popEnterTransition(
        state: S,
        uiState: US
    ): (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        enterTransition(
            state = state,
            uiState = uiState
        )

    protected open fun popExitTransition(
        state: S,
        uiState: US
    ): (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        exitTransition(
            state = state,
            uiState = uiState
        )

    private companion object {
        const val TRANSITION_DURATION = 700
    }
}
