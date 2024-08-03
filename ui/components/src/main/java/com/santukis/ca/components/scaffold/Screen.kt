package com.santukis.ca.components.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout
import com.santukis.injection.core.DependencyInjectorProvider
import com.santukis.navigation.InputArguments
import com.santukis.navigation.ScreenArguments

@Stable
abstract class Screen<S : ScreenState, US : UiState> {

    protected abstract fun screenLayout(
        state: S,
        uiState: US
    ): ScreenLayout<S, US>

    @Composable
    fun Layout(
        modifier: Modifier = Modifier,
        arguments: InputArguments = ScreenArguments(arguments = Unit)
    ) {
        val stateHandler: StateHandler<S, US> = injectViewModel()
        val state = stateHandler.rememberState().value
        val uiState = stateHandler.rememberUiState().value
        val screenLayout = remember {
            screenLayout(
                state = state,
                uiState = uiState
            )
        }

        stateHandler.InitializeHandler()

        screenLayout.Layout(
            modifier = modifier,
            arguments = arguments,
            state = state,
            uiState = uiState,
            onAction = { action ->
                stateHandler.execute(action)
            }
        )
    }

    @Composable
    private fun injectViewModel(): CaViewModel<S, US> =
        DependencyInjectorProvider.getDependency(
            dependency = CaViewModel::class,
            into = this::class
        ) ?: throw NotImplementedError("CaViewModel not provided")
}
