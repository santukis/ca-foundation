package com.santukis.ca.ui.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.santukis.ca.ui.scaffold.states.ScreenConfigurationState
import com.santukis.ca.ui.scaffold.states.screenConfigurationState

/**
 * Represents the state of the UI of a screen.
 *
 * This interface defines the contract for UI state, which includes common UI-related properties
 * that can be shared across different screens.
 */
@Stable
interface UiState {
    /**
     * The configuration state of the screen, such as loading indicators or error messages.
     */
    val screenConfigurationState: ScreenConfigurationState
}

/**
 * A factory Composable function to create a default [UiState].
 *
 * @param screenConfigurationState The initial [ScreenConfigurationState].
 * @return A new [UiState] instance.
 */
@Composable
fun uiState(
    screenConfigurationState: ScreenConfigurationState = screenConfigurationState()
): UiState = DefaultUiState(
    screenConfigurationState = screenConfigurationState
)

/**
 * The default implementation of [UiState].
 *
 * @param screenConfigurationState The configuration state for the screen.
 */
private class DefaultUiState(
    override val screenConfigurationState: ScreenConfigurationState
) : UiState
