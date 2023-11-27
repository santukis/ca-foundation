package com.santukis.ca.components.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout
import com.santukis.ca.components.scaffold.states.ScreenConfigurationState
import com.santukis.ca.components.scaffold.states.rememberScreenConfigurationState
import com.santukis.injection.core.DependencyInjectorProvider

@Stable
abstract class Screen<S : ScreenState> {

    @Composable
    abstract fun rememberScreenLayout(
        screenConfiguration: ScreenConfigurationState
    ): ScreenLayout<S>

    @Composable
    fun Layout(
        modifier: Modifier = Modifier,
        arguments: ScreenArguments = NoArguments(),
        stateHolder: StateHolder<S> = inject(),
        actionHandler: ActionHandler = inject(),
        navigationHandler: (NavigationAction) -> Unit = {}
    ) {
        val state by stateHolder.getState().collectAsState()
        val onActions: (Action) -> Unit = remember {
            { action ->
                when (action) {
                    is NavigationAction -> navigationHandler(action)
                    is ScreenAction -> actionHandler.handle(action)
                }
            }
        }
        val screenConfiguration = rememberScreenConfigurationState()
        val screenLayout: ScreenLayout<S> =
            rememberScreenLayout(screenConfiguration)

        screenLayout
            .Layout(
                modifier = modifier,
                arguments = arguments,
                state = state,
                onAction = onActions
            )
    }

    @Composable
    protected inline fun <reified T : Any> inject(): T =
        DependencyInjectorProvider
            .provide()
            .injectComposable(
                from = this@Screen::class,
                to = T::class
            )
}
