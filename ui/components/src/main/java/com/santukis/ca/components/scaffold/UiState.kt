package com.santukis.ca.components.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import com.santukis.ca.components.scaffold.states.ScreenConfigurationState
import com.santukis.ca.components.scaffold.states.rememberScreenConfigurationState

@Stable
interface UiState {
    val screenConfigurationState: ScreenConfigurationState
}

@Composable
fun rememberUiState(
    screenConfigurationState: ScreenConfigurationState = rememberScreenConfigurationState()
): UiState = remember {
    DefaultUiState(
        screenConfigurationState = screenConfigurationState
    )
}

private class DefaultUiState(
    override val screenConfigurationState: ScreenConfigurationState
): UiState
