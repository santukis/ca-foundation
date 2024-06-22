package com.santukis.ca.components.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.santukis.ca.components.scaffold.states.ScreenConfigurationState
import com.santukis.ca.components.scaffold.states.screenConfigurationState

@Stable
interface UiState {
    val screenConfigurationState: ScreenConfigurationState
}

@Composable
fun uiState(
    screenConfigurationState: ScreenConfigurationState = screenConfigurationState()
): UiState = DefaultUiState(
    screenConfigurationState = screenConfigurationState
)

private class DefaultUiState(
    override val screenConfigurationState: ScreenConfigurationState
) : UiState
