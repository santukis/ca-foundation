package com.santukis.ca.components.scaffold.screenlayouts

import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenState
import com.santukis.ca.components.scaffold.states.NavigationDrawerState
import com.santukis.navigation.InputArguments

abstract class NavigationDrawerScreenLayout<
    S : ScreenState,
    US : NavigationDrawerState
    > : ScreenLayout<S, US>() {

    @Composable
    override fun Layout(
        modifier: Modifier,
        arguments: InputArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    ) {
        ModalNavigationDrawer(
            modifier = modifier,
            drawerContent = {
                DrawerContent(
                    modifier = Modifier
                        .drawerModifier(
                            state = state,
                            uiState = uiState
                        ),
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
                modifier = Modifier
                    .contentModifier(
                        state = state,
                        uiState = uiState
                    ),
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
        arguments: InputArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    ) {
        // no-op
    }

    @Composable
    protected open fun Content(
        modifier: Modifier,
        arguments: InputArguments,
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

    @Composable
    protected open fun Modifier.drawerModifier(
        state: S,
        uiState: US
    ) = this

    @Composable
    protected open fun Modifier.contentModifier(
        state: S,
        uiState: US
    ) = this
}
