package com.santukis.ca.components.scaffold.states

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.santukis.ca.components.scaffold.UiState

interface ScaffoldState : UiState {
    val snackbarHostState: SnackbarHostState
}

@Composable
fun rememberScaffoldState(
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
): ScaffoldState {
    val screenConfigurationState = rememberScreenConfigurationState()

    return remember {
        DefaultScaffoldState(
            snackbarHostState = snackbarHostState,
            screenConfigurationState = screenConfigurationState
        )
    }
}

internal class DefaultScaffoldState(
    override val snackbarHostState: SnackbarHostState,
    override val screenConfigurationState: ScreenConfigurationState
): ScaffoldState
