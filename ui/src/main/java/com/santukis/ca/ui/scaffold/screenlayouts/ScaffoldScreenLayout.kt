package com.santukis.ca.ui.scaffold.screenlayouts

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
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
import com.santukis.ca.ui.navigation.InputArguments
import com.santukis.ca.ui.navigation.ScreenArguments
import com.santukis.ca.ui.scaffold.Action
import com.santukis.ca.ui.scaffold.ScreenState
import com.santukis.ca.ui.scaffold.states.ScaffoldState

/**
 * A [ScreenLayout] that uses a [Scaffold] as its root container.
 *
 * This abstract class provides a standard layout structure with slots for a top bar, bottom bar,
 * floating action button, and snackbar. Subclasses must implement the [Content] function
 * to define the main content of the screen.
 *
 * @param S The type of the screen state, which must extend [ScreenState].
 * @param US The type of the UI state, which must extend [ScaffoldState].
 */
abstract class ScaffoldScreenLayout<
    S : ScreenState,
    US : ScaffoldState
    > : ScreenLayout<S, US>() {

    /**
     * Renders the screen layout using a [Scaffold] composable.
     *
     * It sets up the various slots of the [Scaffold] (top bar, bottom bar, etc.) by calling the
     * corresponding Composable functions. The main content is rendered via the [Content] function.
     *
     * @param modifier A [Modifier] to be applied to the [Scaffold].
     * @param arguments The [InputArguments] for the screen.
     * @param state The current screen state.
     * @param uiState The current scaffold UI state.
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
                        arguments = ScreenArguments(arguments = snackBarData),
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
                    .contentModifier(
                        state = state,
                        uiState = uiState,
                        paddingValues = paddingValues
                    ),
                arguments = arguments,
                state = state,
                uiState = uiState,
                onAction = onAction
            )
        }
    }

    /**
     * The Composable function for the top app bar of the scaffold.
     *
     * Subclasses can override this to provide a custom top bar. By default, it's empty.
     *
     * @param modifier A [Modifier] for the top bar.
     * @param arguments The screen's [InputArguments].
     * @param state The current screen state.
     * @param uiState The current scaffold UI state.
     * @param onAction A lambda for dispatching actions.
     */
    @Composable
    protected open fun TopBar(
        modifier: Modifier,
        arguments: InputArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    ) {
        // no-op
    }

    /**
     * The Composable function for the bottom app bar of the scaffold.
     *
     * Subclasses can override this to provide a custom bottom bar. By default, it's empty.
     *
     * @param modifier A [Modifier] for the bottom bar.
     * @param arguments The screen's [InputArguments].
     * @param state The current screen state.
     * @param uiState The current scaffold UI state.
     * @param onAction A lambda for dispatching actions.
     */
    @Composable
    protected open fun BottomBar(
        modifier: Modifier,
        arguments: InputArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    ) {
        // no-op
    }

    /**
     * The Composable function for displaying a snackbar within the [SnackbarHost].
     *
     * Subclasses can override this to provide a custom snackbar implementation. By default, it's empty.
     * The `arguments` will contain the `SnackbarData` for the specific snackbar being shown.
     *
     * @param modifier A [Modifier] for the snackbar.
     * @param arguments The [InputArguments] containing the `SnackbarData`.
     * @param state The current screen state.
     * @param uiState The current scaffold UI state.
     * @param onAction A lambda for dispatching actions.
     */
    @Composable
    protected open fun Snackbar(
        modifier: Modifier,
        arguments: InputArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    ) {
        // no-op
    }

    /**
     * The Composable function for the floating action button of the scaffold.
     *
     * Subclasses can override this to provide a custom FAB. By default, it's empty.
     *
     * @param modifier A [Modifier] for the FAB.
     * @param arguments The screen's [InputArguments].
     * @param state The current screen state.
     * @param uiState The current scaffold UI state.
     * @param onAction A lambda for dispatching actions.
     */
    @Composable
    protected open fun FloatingActionButton(
        modifier: Modifier,
        arguments: InputArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    ) {
        // no-op
    }

    /**
     * The main content of the screen.
     *
     * Subclasses must implement this function to define the primary UI of the screen.
     * The `modifier` passed to this function includes the padding values from the scaffold.
     *
     * @param modifier A [Modifier] to be applied to the content. It includes padding from the scaffold.
     * @param arguments The [InputArguments] passed to the screen.
     * @param state The current screen state.
     * @param uiState The current scaffold UI state.
     * @param onAction A lambda for dispatching actions.
     */
    @Composable
    protected abstract fun Content(
        modifier: Modifier,
        arguments: InputArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    )

    /**
     * Determines the position of the floating action button.
     *
     * @param state The current screen state.
     * @param uiState The current scaffold UI state.
     * @return The [FabPosition] for the FAB. Defaults to [FabPosition.End].
     */
    protected open fun floatingActionButtonPosition(
        state: S,
        uiState: US
    ): FabPosition = FabPosition.End

    /**
     * Determines the background color of the scaffold's container.
     *
     * @param state The current screen state.
     * @param uiState The current scaffold UI state.
     * @return The [Color] for the container. Defaults to the theme's background color.
     */
    @Composable
    protected open fun containerColor(
        state: S,
        uiState: US
    ): Color = MaterialTheme.colorScheme.background

    /**
     * Determines the preferred content color for the scaffold's container.
     *
     * @param state The current screen state.
     * @param uiState The current scaffold UI state.
     * @return The preferred [Color] for content. Defaults to the color calculated by [contentColorFor].
     */
    @Composable
    protected open fun contentColor(
        state: S,
        uiState: US
    ): Color = contentColorFor(containerColor(state, uiState))

    /**
     * Specifies the window insets to be passed to the scaffold's content.
     *
     * @param state The current screen state.
     * @param uiState The current scaffold UI state.
     * @return The [WindowInsets] for the content. Defaults to [ScaffoldDefaults.contentWindowInsets].
     */
    @Composable
    protected open fun contentWindowInsets(
        state: S,
        uiState: US
    ): WindowInsets = ScaffoldDefaults.contentWindowInsets

    /**
     * An extension function to apply a [Modifier] to the main content of the screen.
     *
     * By default, it applies the padding values from the scaffold. Subclasses can override this
     * to add more modifiers to the content.
     *
     * @param state The current screen state.
     * @param uiState The current scaffold UI state.
     * @param paddingValues The padding values provided by the [Scaffold].
     * @return The [Modifier] to be applied to the content.
     */
    @Composable
    protected open fun Modifier.contentModifier(
        state: S,
        uiState: US,
        paddingValues: PaddingValues
    ) = this
        .then(
            padding(paddingValues)
        )
}
