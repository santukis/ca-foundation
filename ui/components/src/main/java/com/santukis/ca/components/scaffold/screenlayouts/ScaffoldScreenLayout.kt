package com.santukis.ca.components.scaffold.screenlayouts

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.ScreenState
import com.santukis.ca.components.scaffold.arguments.SnackbarArguments
import com.santukis.ca.components.scaffold.states.ScaffoldState

abstract class ScaffoldScreenLayout<
        S : ScreenState, US : ScaffoldState> : ScreenLayout<S, US>() {

    @Composable
    override fun Layout(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    ) {
        Scaffold(
            modifier = modifier,
            topBar = {
                TopBar(
                    modifier = Modifier,
                    arguments = arguments,
                    state = state,
                    uiState = uiState,
                    onAction = onAction
                )
            },
            bottomBar = {
                BottomBar(
                    modifier = Modifier,
                    arguments = arguments,
                    state = state,
                    uiState = uiState,
                    onAction = onAction
                )
            },
            snackbarHost = {
                SnackbarHost(
                    modifier = Modifier,
                    hostState = uiState.snackbarHostState,
                ) { snackBarData ->
                    Snackbar(
                        modifier = Modifier,
                        arguments = SnackbarArguments(snackBarData),
                        state = state,
                        uiState = uiState,
                        onAction = onAction
                    )
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    modifier = Modifier,
                    arguments = arguments,
                    state = state,
                    uiState = uiState,
                    onAction = onAction
                )
            },
            floatingActionButtonPosition = floatingActionButtonPosition(
                state = state,
                uiState = uiState
            ),
            containerColor = containerColor(
                state = state,
                uiState = uiState
            ),
            contentColor = contentColor(
                state = state,
                uiState = uiState
            ),
            contentWindowInsets = contentWindowInsets(
                state = state,
                uiState = uiState
            )
        ) { paddingValues ->
            Content(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                arguments = arguments,
                state = state,
                uiState = uiState,
                onAction = onAction
            )
        }
    }

    @Composable
    protected open fun TopBar(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    ) {
        // no-op
    }

    @Composable
    protected open fun BottomBar(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    ) {
        // no-op
    }

    @Composable
    protected open fun Snackbar(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    ) {
        // no-op
    }

    @Composable
    protected open fun FloatingActionButton(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    ) {
        // no-op
    }

    @Composable
    protected abstract fun Content(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    )

    protected open fun floatingActionButtonPosition(
        state: S,
        uiState: US
    ): FabPosition = FabPosition.End

    @Composable
    protected open fun containerColor(
        state: S,
        uiState: US
    ): Color = MaterialTheme.colorScheme.background

    @Composable
    protected open fun contentColor(
        state: S,
        uiState: US
    ): Color = contentColorFor(containerColor(state, uiState))

    @Composable
    protected open fun contentWindowInsets(
        state: S,
        uiState: US
    ): WindowInsets = ScaffoldDefaults.contentWindowInsets
}
