package com.santukis.ca.ui.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santukis.ca.ui.navigation.InputArguments

/**
 * Represents a reusable block of UI within a screen.
 *
 * Screen blocks are modular components that can be composed to build complex screens.
 * They receive state and can trigger actions, but they don't have their own ViewModel or lifecycle.
 *
 * @param S The type of the screen state.
 * @param US The type of the UI state.
 */
abstract class ScreenBlock<S : ScreenState, US : UiState> {

    /**
     * The Composable function that renders the UI for this block.
     *
     * @param modifier A [Modifier] to be applied to the block's layout.
     * @param arguments The [InputArguments] passed to the screen.
     * @param state The current screen state.
     * @param uiState The current UI state.
     * @param onAction A lambda to be called when an action is triggered within the block.
     */
    @Composable
    abstract fun Layout(
        modifier: Modifier,
        arguments: InputArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    )
}
