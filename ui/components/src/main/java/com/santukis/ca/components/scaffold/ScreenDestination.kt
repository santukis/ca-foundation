package com.santukis.ca.components.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.santukis.navigation.ComposableDestination
import com.santukis.navigation.InputArguments
import com.santukis.navigation.Router

abstract class ScreenDestination(
    override val router: Router
) : ComposableDestination, ActionHandler {

    abstract fun getScreenDestination(): Screen<*, *>

    @Composable
    override fun DestinationScreen(arguments: InputArguments) {
        InitializeHandler()

        val screen = remember { getScreenDestination() }

        screen.Layout(
            modifier = Modifier.screenModifier(),
            arguments = arguments
        )
    }

    override fun handle(action: Action) {
        // no-op
    }

    protected open fun Modifier.screenModifier(): Modifier = this
}
