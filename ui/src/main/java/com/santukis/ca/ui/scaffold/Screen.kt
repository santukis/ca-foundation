package com.santukis.ca.ui.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.santukis.ca.ui.navigation.InputArguments
import com.santukis.ca.ui.navigation.ScreenArguments
import com.santukis.ca.ui.scaffold.screenlayouts.ScreenLayout
import com.santukis.injection.core.DependencyInjectorProvider

/**
 * Represents a fundamental building block for a UI screen in the application.
 *
 * This abstract class encapsulates the logic for a screen, connecting the screen's state (`S`),
 * the UI state (`US`), a `StateHolder` (typically a [CaViewModel]), and the [ScreenLayout]
 * that defines the visual representation.
 *
 * @param S The type of the screen-specific state, which must extend [ScreenState].
 * @param US The type of the UI-specific state, which must extend [UiState].
 */
@Stable
abstract class Screen<S : ScreenState, US : UiState> {

    /**
     * Provides the [ScreenLayout] for this screen.
     *
     * Subclasses must implement this method to define the UI structure of the screen
     * based on the current [state] and [uiState].
     *
     * @param state The current screen state.
     * @param uiState The current UI state.
     * @return The [ScreenLayout] responsible for rendering the UI.
     */
    protected abstract fun screenLayout(
        state: S,
        uiState: US
    ): ScreenLayout<S, US>

    /**
     * The main Composable function that renders the screen.
     *
     * This function orchestrates the screen's setup by:
     * 1. Injecting the associated [CaViewModel] as a [StateHolder].
     * 2. Obtaining and remembering the screen and UI states.
     * 3. Obtaining the [ScreenLayout] from the [screenLayout] method.
     * 4. Initializing the action handler.
     * 5. Rendering the [ScreenLayout] and passing the state, arguments, and an action handler lambda.
     *
     * @param modifier A [Modifier] to be applied to the screen's layout.
     * @param arguments The [InputArguments] passed to this screen, defaulting to empty arguments.
     */
    @Composable
    fun Layout(
        modifier: Modifier = Modifier,
        arguments: InputArguments = ScreenArguments(arguments = Unit)
    ) {
        val stateHolder = injectViewModel()
        val state = stateHolder.rememberState().value
        val uiState = stateHolder.rememberUiState().value
        val screenLayout = remember {
            screenLayout(
                state = state,
                uiState = uiState
            )
        }

        stateHolder.InitializeHandler()

        screenLayout.Layout(
            modifier = modifier,
            arguments = arguments,
            state = state,
            uiState = uiState,
            onAction = { action ->
                stateHolder.execute(action)
            }
        )
    }

    /**
     * Injects and returns the [CaViewModel] associated with this screen.
     * It uses [DependencyInjectorProvider] to get the required dependency.
     *
     * @return The injected instance of [CaViewModel].
     * @throws NotImplementedError if the [CaViewModel] dependency is not provided in the dependency graph.
     */
    @Composable
    private fun injectViewModel(): CaViewModel<S, US> =
        DependencyInjectorProvider.getDependency(
            dependency = CaViewModel::class,
            into = this::class
        ) ?: throw NotImplementedError("CaViewModel not provided")
}
