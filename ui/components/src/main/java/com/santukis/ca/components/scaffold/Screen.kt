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
        onAction: (Action) -> Unit = {}
    ) {
        val viewModel: CaViewModel<S> = injectViewModel()
        val state = remember { viewModel.getState() }
        val uiState = uiState()
        val onActions: (Action) -> Unit = remember {
            { action ->
                viewModel.handle(action)
                onAction(action)
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
    private fun injectViewModel(): CaViewModel<S> =
        DependencyInjectorProvider.getDependency(
            dependency = CaViewModel::class,
            into = this::class
        ) ?: throw NotImplementedError("CaViewModel not provided")
}
