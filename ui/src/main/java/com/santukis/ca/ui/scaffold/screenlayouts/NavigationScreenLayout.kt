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

/**
 * A [ScreenLayout] that uses a [NavHost] as its root container to host a navigation graph.
 *
 * This class is designed for screens that act as navigation hosts. It sets up a [NavHost]
 * and builds a navigation graph provided by the [NavigationState].
 *
 * @param S The type of the screen state.
 * @param US The type of the UI state, which must extend [NavigationState].
 */
open class NavigationScreenLayout<
    S : ScreenState,
    US : NavigationState
    > : ScreenLayout<S, US>() {

    /**
     * Renders the screen layout using a [NavHost] composable.
     *
     * It configures the [NavHost] with the navigation controller from the [uiState]'s router,
     * the start destination from the navigation graph, and customizable transitions. It then
     * builds the graph using the `buildGraph` function from the [uiState]'s navigation graph.
     *
     * @param modifier A [Modifier] to be applied to the [NavHost].
     * @param arguments The [InputArguments] for the screen, which are passed down to the graph.
     * @param state The current screen state.
     * @param uiState The current navigation UI state.
     * @param onAction A lambda for dispatching actions (not directly used by NavHost but required by the base class).
     */
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

    /**
     * Determines the alignment of the content within the [NavHost].
     *
     * @param state The current screen state.
     * @param uiState The current navigation UI state.
     * @return The [Alignment] for the content. Defaults to [Alignment.Center].
     */
    protected open fun contentAlignment(
        state: S,
        uiState: US
    ): Alignment = Alignment.Center

    /**
     * Defines a route for the [NavHost] itself, if it is a nested graph.
     *
     * @param state The current screen state.
     * @param uiState The current navigation UI state.
     * @return The route string, or null if not a nested graph. Defaults to null.
     */
    protected open fun route(
        state: S,
        uiState: US
    ): String? = null

    /**
     * Defines the enter transition for destinations within this [NavHost].
     *
     * @param state The current screen state.
     * @param uiState The current navigation UI state.
     * @return A lambda that provides the [EnterTransition]. Defaults to a fade-in animation.
     */
    protected open fun enterTransition(
        state: S,
        uiState: US
    ): (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        { fadeIn(animationSpec = tween(TRANSITION_DURATION)) }

    /**
     * Defines the exit transition for destinations within this [NavHost].
     *
     * @param state The current screen state.
     * @param uiState The current navigation UI state.
     * @return A lambda that provides the [ExitTransition]. Defaults to a fade-out animation.
     */
    protected open fun exitTransition(
        state: S,
        uiState: US
    ): (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        { fadeOut(animationSpec = tween(TRANSITION_DURATION)) }

    /**
     * Defines the pop enter transition for destinations within this [NavHost].
     *
     * @param state The current screen state.
     * @param uiState The current navigation UI state.
     * @return A lambda that provides the [EnterTransition]. Defaults to the value of [enterTransition].
     */
    protected open fun popEnterTransition(
        state: S,
        uiState: US
    ): (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        enterTransition(
            state = state,
            uiState = uiState
        )

    /**
     * Defines the pop exit transition for destinations within this [NavHost].
     *
     * @param state The current screen state.
     * @param uiState The current navigation UI state.
     * @return A lambda that provides the [ExitTransition]. Defaults to the value of [exitTransition].
     */
    protected open fun popExitTransition(
        state: S,
        uiState: US
    ): (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        exitTransition(
            state = state,
            uiState = uiState
        )

    private companion object {
        /**
         * Default duration for transitions in milliseconds.
         */
        const val TRANSITION_DURATION = 700
    }
}
