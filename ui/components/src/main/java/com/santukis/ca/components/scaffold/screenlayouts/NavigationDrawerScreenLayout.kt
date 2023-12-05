package com.santukis.ca.components.scaffold.screenlayouts

import androidx.annotation.CallSuper
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.ScreenState
import com.santukis.ca.components.scaffold.actions.NavigationDrawerAction
import com.santukis.ca.components.scaffold.states.NavigationDrawerState
import com.santukis.ca.components.scaffold.states.ScreenConfigurationState
import com.santukis.ca.components.scaffold.states.rememberNavigationDrawerState
import com.santukis.ca.components.scaffold.states.rememberScreenConfigurationState

abstract class NavigationDrawerScreenLayout<S : ScreenState> : ScreenLayout<S>() {

    private lateinit var navigationDrawerState: NavigationDrawerState

    @CallSuper
    @Composable
    override fun UiState(arguments: ScreenArguments, state: S) {
        navigationDrawerState = rememberNavigationDrawerState()
    }

    @Composable
    abstract fun rememberContentLayout(
        screenConfiguration: ScreenConfigurationState
    ): ScreenLayout<S>

    @Composable
    protected open fun DrawerContent(
        arguments: ScreenArguments,
        state: S,
        onAction: (Action) -> Unit
    ) {
        // no-op
    }

    @Composable
    override fun Layout(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: S,
        onAction: (Action) -> Unit
    ) {
        UiState(
            arguments = arguments,
            state = state
        )

        val onActions: (Action) -> Unit = remember {
            { action ->
                when (action) {
                    is NavigationDrawerAction.OpenDrawer -> navigationDrawerState.openDrawer()
                    is NavigationDrawerAction.CloseDrawer -> navigationDrawerState.closeDrawer()
                }

                onAction(action)
            }
        }
        val screenConfiguration = rememberScreenConfigurationState()
        val contentLayout: ScreenLayout<S> =
            rememberContentLayout(screenConfiguration)

        ModalNavigationDrawer(
            modifier = modifier,
            drawerContent = {
                DrawerContent(
                    arguments = arguments,
                    state = state,
                    onAction = onActions
                )
            },
            drawerState = navigationDrawerState.drawerState
        ) {
            contentLayout
                .Layout(
                    modifier = Modifier,
                    arguments = arguments,
                    state = state,
                    onAction = onActions
                )
        }
    }
}
