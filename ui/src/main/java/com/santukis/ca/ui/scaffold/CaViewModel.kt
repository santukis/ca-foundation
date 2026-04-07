package com.santukis.ca.ui.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel

/**
 * An abstract [ViewModel] that also implements [StateHandler].
 * This class serves as a base for ViewModels that manage screen state and UI state.
 *
 * @param S The type of the screen state, which must extend [ScreenState].
 * @param US The type of the UI state, which must extend [UiState].
 */
abstract class CaViewModel<S : ScreenState, US : UiState> :
    ViewModel(),
    StateHolder<S, US>,
    StateHandler<S, US> {

    internal lateinit var state: MutableState<S>

    internal lateinit var uiState: MutableState<US>

    /**
     * Updates the screen state.
     * This method should be called to modify the screen state in a safe way.
     *
     * @param update A lambda function that takes the current state and returns the updated state.
     */
    override fun updateState(update: (S) -> S) {
        state.value = update(state.value)
    }

    /**
     * Executes a block of code on the current screen state.
     * This is useful for reading the state without modifying it.
     *
     * @param execute A lambda function to be executed with the current screen state.
     */
    override fun executeOnState(execute: (S) -> Unit) {
        execute(this.state.value)
    }

    /**
     * Updates the UI state.
     *
     * @param update A lambda function that takes the current UI state and returns the updated state.
     */
    override fun updateUiState(update: (US) -> US) {
        uiState.value = update(uiState.value)
    }

    /**
     * Executes a block of code on the current UI state.
     *
     * @param execute A lambda function to be executed with the current UI state.
     */
    override fun executeOnUiState(execute: (US) -> Unit) {
        execute(this.uiState.value)
    }
}

/**
 * Remembers and provides the screen state as a [State] object.
 * It initializes the state using [StateHolder.initializeState] and remembers it across recompositions.
 */
@Composable
internal fun <S : ScreenState> CaViewModel<S, *>.rememberState(): State<S> {
    val state = initializeState()

    this@CaViewModel.state = remember {
        mutableStateOf(state)
    }

    return this@CaViewModel.state
}

/**
 * Remembers and provides the UI state as a [State] object.
 * It initializes the UI state using [StateHolder.initializeUiState] and remembers it across recompositions.
 */
@Composable
internal fun <US : UiState> CaViewModel<*, US>.rememberUiState(): State<US> {
    val uiState = initializeUiState()

    this@CaViewModel.uiState = remember {
        mutableStateOf(uiState)
    }

    return this@CaViewModel.uiState
}
