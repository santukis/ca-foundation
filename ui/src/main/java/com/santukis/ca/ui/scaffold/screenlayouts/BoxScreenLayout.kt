package com.santukis.ca.ui.scaffold.screenlayouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.santukis.ca.ui.navigation.InputArguments
import com.santukis.ca.ui.scaffold.Action
import com.santukis.ca.ui.scaffold.ScreenState
import com.santukis.ca.ui.scaffold.UiState

/**
 * A [ScreenLayout] that uses a [Box] as its root container.
 *
 * This abstract class provides a simple way to create screen layouts where UI elements
 * are stacked on top of each other. Subclasses must implement the [Content] function
 * to define the actual content of the screen.
 *
 * @param S The type of the screen state.
 * @param US The type of the UI state.
 */
abstract class BoxScreenLayout<
    S : ScreenState,
    US : UiState
    > : ScreenLayout<S, US>() {

    /**
     * The Composable function that defines the content of the screen within a [BoxScope].
     *
     * @param modifier A [Modifier] to be applied to the content.
     * @param arguments The [InputArguments] passed to the screen.
     * @param state The current screen state.
     * @param uiState The current UI state.
     * @param onAction A lambda to be called when an [Action] is triggered.
     */
    @Composable
    protected abstract fun BoxScope.Content(
        modifier: Modifier,
        arguments: InputArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    )

    /**
     * Renders the screen layout using a [Box] composable.
     *
     * It sets up the [Box] with customizable alignment and constraint propagation, and then
     * calls the [Content] function to render the actual UI.
     *
     * @param modifier A [Modifier] to be applied to the [Box].
     * @param arguments The [InputArguments] for the screen.
     * @param state The current screen state.
     * @param uiState The current UI state.
     * @param onAction A lambda for dispatching actions.
     */
    @Composable
    override fun Layout(
        modifier: Modifier,
        arguments: InputArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    ) {
        Box(
            modifier = modifier,
            contentAlignment = contentAlignment(
                state = state,
                uiState = uiState
            ),
            propagateMinConstraints = propagateMinConstraints(
                state = state,
                uiState = uiState
            )
        ) {
            Content(
                modifier = Modifier
                    .contentModifier(
                        scope = this,
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

    /**
     * Determines the alignment of the content within the [Box].
     *
     * Subclasses can override this to provide a different alignment.
     *
     * @param state The current screen state.
     * @param uiState The current UI state.
     * @return The [Alignment] for the content. Defaults to [Alignment.TopStart].
     */
    protected open fun contentAlignment(
        state: S,
        uiState: US
    ): Alignment = Alignment.TopStart

    /**
     * Determines whether minimum constraints should be propagated to the content.
     *
     * Subclasses can override this to change the behavior.
     *
     * @param state The current screen state.
     * @param uiState The current UI state.
     * @return `true` to propagate minimum constraints, `false` otherwise. Defaults to `false`.
     */
    protected open fun propagateMinConstraints(
        state: S,
        uiState: US
    ): Boolean = false

    /**
     * An extension function to apply a [Modifier] to the content of the screen.
     *
     * Subclasses can override this to provide a custom modifier for the content.
     *
     * @param scope The [BoxScope] of the content.
     * @param state The current screen state.
     * @param uiState The current UI state.
     * @return The [Modifier] to be applied to the content.
     */
    @Composable
    protected open fun Modifier.contentModifier(
        scope: BoxScope,
        state: S,
        uiState: US
    ) = this
}
