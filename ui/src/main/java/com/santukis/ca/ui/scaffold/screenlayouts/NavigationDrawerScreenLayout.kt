package com.santukis.ca.ui.scaffold.screenlayouts

import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.santukis.ca.ui.scaffold.Action
import com.santukis.ca.ui.scaffold.ScreenState
import com.santukis.ca.ui.scaffold.states.NavigationDrawerState
import com.santukis.ca.ui.navigation.InputArguments

/**
 * A [ScreenLayout] that uses a [ModalNavigationDrawer] as its root container.
 *
 * This class provides a layout structure with a main content area and a navigation drawer that can be
 * opened and closed. Subclasses can provide content for both the drawer and the main area by
 * overriding [DrawerContent] and [Content] respectively.
 *
 * @param S The type of the screen state.
 * @param US The type of the UI state, which must extend [NavigationDrawerState].
 */
abstract class NavigationDrawerScreenLayout<
    S : ScreenState,
    US : NavigationDrawerState
    > : ScreenLayout<S, US>() {

    /**
     * Renders the screen layout using a [ModalNavigationDrawer] composable.
     *
     * It sets up the drawer with content from [DrawerContent] and the main content area with
     * content from [Content]. The drawer's state (open/closed) is controlled by the [uiState].
     *
     * @param modifier A [Modifier] to be applied to the [ModalNavigationDrawer].
     * @param arguments The [InputArguments] for the screen.
     * @param state The current screen state.
     * @param uiState The current navigation drawer UI state.
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
        ModalNavigationDrawer(
            modifier = modifier,
            drawerContent = {
                DrawerContent(
                    modifier = Modifier
                        .drawerModifier(
                            state = state,
                            uiState = uiState
                        ),
                    arguments = arguments,
                    state = state,
                    uiState = uiState,
                    onAction = onAction
                )
            },
            drawerState = uiState.drawerState,
            gesturesEnabled = gesturesEnabled(
                state = state,
                uiState = uiState
            ),
            scrimColor = scrimColor(
                state = state,
                uiState = uiState
            )
        ) {
            Content(
                modifier = Modifier
                    .contentModifier(
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
     * The Composable function for the content of the navigation drawer.
     *
     * Subclasses can override this to provide custom content for the drawer. By default, it's empty.
     *
     * @param modifier A [Modifier] for the drawer content.
     * @param arguments The screen's [InputArguments].
     * @param state The current screen state.
     * @param uiState The current navigation drawer UI state.
     * @param onAction A lambda for dispatching actions.
     */
    @Composable
    protected open fun DrawerContent(
        modifier: Modifier,
        arguments: InputArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    ) {
        // no-op
    }

    /**
     * The Composable function for the main content of the screen.
     *
     * Subclasses can override this to provide the primary UI that is displayed when the drawer is closed.
     * By default, it's empty.
     *
     * @param modifier A [Modifier] for the main content.
     * @param arguments The screen's [InputArguments].
     * @param state The current screen state.
     * @param uiState The current navigation drawer UI state.
     * @param onAction A lambda for dispatching actions.
     */
    @Composable
    protected open fun Content(
        modifier: Modifier,
        arguments: InputArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    ) {
        // no-op
    }

    /**
     * Determines whether the drawer can be opened and closed with gestures.
     *
     * @param state The current screen state.
     * @param uiState The current navigation drawer UI state.
     * @return `true` to enable gestures, `false` to disable them. Defaults to `true`.
     */
    protected open fun gesturesEnabled(
        state: S,
        uiState: US
    ): Boolean = true

    /**
     * Defines the color of the scrim that is applied to the main content when the drawer is open.
     *
     * @param state The current screen state.
     * @param uiState The current navigation drawer UI state.
     * @return The [Color] of the scrim. Defaults to [DrawerDefaults.scrimColor].
     */
    @Composable
    protected open fun scrimColor(
        state: S,
        uiState: US
    ): Color = DrawerDefaults.scrimColor

    /**
     * An extension function to apply a [Modifier] to the drawer content.
     *
     * @param state The current screen state.
     * @param uiState The current navigation drawer UI state.
     * @return The [Modifier] to be applied.
     */
    @Composable
    protected open fun Modifier.drawerModifier(
        state: S,
        uiState: US
    ) = this

    /**
     * An extension function to apply a [Modifier] to the main content.
     *
     * @param state The current screen state.
     * @param uiState The current navigation drawer UI state.
     * @return The [Modifier] to be applied.
     */
    @Composable
    protected open fun Modifier.contentModifier(
        state: S,
        uiState: US
    ) = this
}
