package com.santukis.ca.components.scaffold.screenlayouts

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.ScreenState
import com.santukis.ca.components.scaffold.states.ScreenConfigurationState
import com.santukis.ca.components.scaffold.states.rememberScreenConfigurationState

abstract class NavigationDrawerScreenLayout<S : ScreenState> : ScreenLayout<S>() {

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

        val screenConfiguration = rememberScreenConfigurationState()
        val contentLayout: ScreenLayout<S> =
            rememberContentLayout(screenConfiguration)

        ModalNavigationDrawer(
            modifier = modifier,
            drawerContent = {
                DrawerContent(
                    arguments = arguments,
                    state = state,
                    onAction = onAction
                )
            },
            drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
        ) {
            contentLayout
                .Layout(
                    modifier = Modifier,
                    arguments = arguments,
                    state = state,
                    onAction = onAction
                )
        }
    }
}
