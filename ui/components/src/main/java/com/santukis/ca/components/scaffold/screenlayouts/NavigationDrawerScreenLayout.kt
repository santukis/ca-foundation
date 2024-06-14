package com.santukis.ca.components.scaffold.screenlayouts

import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.ScreenState
import com.santukis.ca.components.scaffold.states.NavigationDrawerState

abstract class NavigationDrawerScreenLayout<
        S : ScreenState, US : NavigationDrawerState> : ScreenLayout<S, US>() {

    @Composable
    override fun Layout(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    ) {
        ModalNavigationDrawer(
            modifier = modifier,
            drawerContent = {
                DrawerContent(
                    modifier = Modifier,
                    arguments = arguments,
                    state = state,
                    uiState = uiState,
                    onAction = onAction
                )
            },
            drawerState = uiState.drawerState,
            gesturesEnabled = gesturesEnabled(
                state = state,
                uiState = uiState
            ),
            scrimColor = scrimColor(
                state = state,
                uiState = uiState
            )
        ) {
            Content(
                modifier = Modifier,
                arguments = arguments,
                state = state,
                uiState = uiState,
                onAction = onAction
            )
        }
    }

    @Composable
    protected open fun DrawerContent(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    ) {
        // no-op
    }

    @Composable
    protected open fun Content(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    ) {
        // no-op
    }

    protected open fun gesturesEnabled(
        state: S,
        uiState: US
    ): Boolean = true

    @Composable
    protected open fun scrimColor(
        state: S,
        uiState: US
    ): Color = DrawerDefaults.scrimColor
}
