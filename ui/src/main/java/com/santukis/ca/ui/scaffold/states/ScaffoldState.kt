package com.santukis.ca.ui.scaffold.states

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.santukis.ca.ui.scaffold.UiState

/**
 * Represents the UI state of a scaffold, including components like the snackbar.
 *
 * It extends [UiState] to be used as a screen's UI state.
 *
 * @see UiState
 */
interface ScaffoldState : UiState {
    /**
     * The state of the `SnackbarHost`, which is used to show snackbars.
     */
    val snackbarHostState: SnackbarHostState
}

/**
 * Creates and remembers a [ScaffoldState].
 *
 * This function provides a convenient way to create and manage the state of a scaffold within a Composable.
 *
 * @param snackbarHostState The [SnackbarHostState] to be used for showing snackbars.
 * Defaults to a new remembered instance.
 * @return A remembered instance of [ScaffoldState].
 */
@Composable
fun scaffoldState(
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
): ScaffoldState =
    DefaultScaffoldState(
        snackbarHostState = snackbarHostState,
    )

/**
 * The default implementation of [ScaffoldState].
 *
 * @param snackbarHostState The state for the snackbar host.
 */
internal class DefaultScaffoldState(
    override val snackbarHostState: SnackbarHostState,
) : ScaffoldState
