package com.santukis.ca.ui.scaffold.screenlayouts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santukis.ca.ui.navigation.InputArguments
import com.santukis.ca.ui.scaffold.Action
import com.santukis.ca.ui.scaffold.ScreenState
import com.santukis.ca.ui.scaffold.UiState

/**
 * Defines the basic structure for a screen's layout.
 *
 * This abstract class serves as a base for different types of screen layouts. It defines a single
 * `Layout` Composable function that is responsible for rendering the UI of a screen.
 *
 * @param S The type of the screen state, which must extend [ScreenState].
 * @param US The type of the UI state, which must extend [UiState].
 */
abstract class ScreenLayout<S : ScreenState, US : UiState> {

    /**
     * The main Composable function that renders the screen's layout.
     *
     * Subclasses must implement this function to define the actual UI of the screen.
     *
     * @param modifier A [Modifier] to be applied to the layout.
     * @param arguments The [InputArguments] passed to the screen.
     * @param state The current screen state.
     * @param uiState The current UI state.
     * @param onAction A lambda function to be called when an [Action] is triggered from the UI.
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
