package com.santukis.ca.ui.scaffold.states

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.santukis.ca.ui.scaffold.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Represents the state of a navigation drawer, including its visibility and drawer-specific properties.
 *
 * It extends [UiState] to be used as a screen's UI state and [VisibilityState] to provide basic
 * show/hide functionality.
 *
 * @see UiState
 * @see VisibilityState
 */
interface NavigationDrawerState : UiState, VisibilityState {
    /**
     * The underlying [DrawerState] from Material 3, which controls the navigation drawer's
     * position and state (opened/closed).
     */
    val drawerState: DrawerState
}

/**
 * Creates and remembers a [NavigationDrawerState] for a navigation drawer.
 *
 * This function provides a convenient way to manage the state of a navigation drawer within a Composable.
 *
 * @param initialValue The initial value for the drawer, either [DrawerValue.Closed] or [DrawerValue.Open].
 * Defaults to [DrawerValue.Closed].
 * @return A remembered instance of [NavigationDrawerState].
 */
@Composable
fun navigationDrawerUiState(
    initialValue: DrawerValue = DrawerValue.Closed
): NavigationDrawerState {
    val screenConfigurationState = screenConfigurationState()
    val drawerState = rememberDrawerState(initialValue = initialValue)
    val coroutineScope = rememberCoroutineScope()

    return DefaultNavigationDrawerState(
        drawerState = drawerState,
        screenConfigurationState = screenConfigurationState,
        coroutineScope = coroutineScope
    )
}

/**
 * The default implementation of [NavigationDrawerState].
 *
 * It uses a [CoroutineScope] to launch suspend functions for opening and closing the drawer.
 *
 * @param drawerState The underlying Material 3 [DrawerState].
 * @param screenConfigurationState The configuration state for the screen.
 * @param coroutineScope The coroutine scope used to animate the drawer's visibility.
 */
internal class DefaultNavigationDrawerState(
    override val drawerState: DrawerState,
    override val screenConfigurationState: ScreenConfigurationState,
    private val coroutineScope: CoroutineScope
) : NavigationDrawerState {

    /**
     * Indicates whether the navigation drawer is currently open.
     *
     * @return `true` if the drawer is open, `false` otherwise.
     */
    override fun isVisible(): Boolean = drawerState.isOpen

    /**
     * Opens the navigation drawer with an animation.
     *
     * @param onShown A callback to be invoked after the drawer has been fully opened.
     */
    override fun show(onShown: () -> Unit) {
        coroutineScope.launch {
            drawerState.open()
        }.invokeOnCompletion {
            onShown()
        }
    }

    /**
     * Closes the navigation drawer with an animation.
     *
     * @param onHidden A callback to be invoked after the drawer has been fully closed.
     */
    override fun hide(onHidden: () -> Unit) {
        coroutineScope.launch {
            drawerState.close()
        }.invokeOnCompletion {
            onHidden()
        }
    }
}
