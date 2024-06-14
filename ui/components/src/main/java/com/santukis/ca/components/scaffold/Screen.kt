package com.santukis.ca.components.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout
import com.santukis.injection.core.DependencyInjectorProvider

@Stable
abstract class Screen<S : ScreenState, US : UiState> {

    protected abstract fun screenLayout(
        state: S,
        uiState: US
    ): ScreenLayout<S, US>

    @Composable
    protected abstract fun uiState(): US

    @Composable
    fun Layout(
        modifier: Modifier = Modifier,
        arguments: ScreenArguments = NoArguments(),
        stateHolder: StateHolder<S> = inject(),
        actionHandler: ActionHandler = inject(),
        navigationHandler: (NavigationAction) -> Unit = {}
    ) {
        val state = remember { stateHolder.getState() }
        val uiState = uiState()
        val onActions: (Action) -> Unit = remember {
            { action ->
                when (action) {
                    is NavigationAction -> navigationHandler(action)
                    is ScreenAction -> actionHandler.handle(action)
                }
            }
        }
        val screenLayout = remember {
            screenLayout(
                state = state.value,
                uiState = uiState
            )
        }

        screenLayout.Layout(
                modifier = modifier,
                arguments = arguments,
                state = state.value,
                uiState = uiState,
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
