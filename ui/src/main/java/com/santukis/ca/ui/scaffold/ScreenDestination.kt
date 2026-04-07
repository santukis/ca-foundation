package com.santukis.ca.ui.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.santukis.ca.ui.navigation.ComposableDestination
import com.santukis.ca.ui.navigation.InputArguments
import com.santukis.ca.ui.navigation.Router

/**
 * Represents a destination that is a screen in the navigation graph.
 *
 * This abstract class combines the concepts of a [ComposableDestination] and an [ActionHandler].
 * It provides a concrete implementation for rendering a [Screen] and handling actions.
 *
 * @param router The [Router] used for navigation.
 */
abstract class ScreenDestination(
    override val router: Router
) : ComposableDestination, ActionHandler {

    /**
     * Returns the [Screen] instance associated with this destination.
     *
     * Subclasses must implement this method to provide the specific [Screen] to be displayed.
     *
     * @return The [Screen] for this destination.
     */
    abstract fun getScreenDestination(): Screen<*, *>

    /**
     * The Composable function that renders the destination screen.
     *
     * It initializes the action handler, gets the [Screen] instance, and calls its `Layout` function.
     *
     * @param arguments The [InputArguments] passed to the screen.
     */
    @Composable
    override fun DestinationScreen(arguments: InputArguments) {
        InitializeHandler()

        val screen = remember { getScreenDestination() }

        screen.Layout(
            modifier = Modifier.screenModifier(),
            arguments = arguments
        )
    }

    /**
     * Handles an [Action].
     *
     * By default, this is a no-op. Subclasses can override this to handle specific actions
     * that are not handled by the screen's ViewModel.
     *
     * @param action The [Action] to handle.
     */
    override fun handle(action: Action) {
        // no-op
    }

    /**
     * An extension function to apply a [Modifier] to the screen's layout.
     *
     * Subclasses can override this to provide a custom modifier.
     *
     * @return The [Modifier] to be applied.
     */
    protected open fun Modifier.screenModifier(): Modifier = this
}
