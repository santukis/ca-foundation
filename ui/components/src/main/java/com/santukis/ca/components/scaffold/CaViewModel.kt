package com.santukis.ca.components.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel

abstract class CaViewModel<S : ScreenState, US : UiState> :
    ViewModel(),
    StateHolder<S, US> {

    private lateinit var state: MutableState<S>

    private lateinit var uiState: MutableState<US>

    @Composable
    override fun rememberState(): State<S> {
        val state = initializeState()

        this@CaViewModel.state = remember {
            mutableStateOf(state)
        }

        return this@CaViewModel.state
    }

    override fun updateState(update: (S) -> S) {
        state.value = update(state.value)
    }

    override fun executeOnState(execute: (S) -> Unit) {
        execute(this.state.value)
    }

    @Composable
    override fun rememberUiState(): State<US> {
        val uiState = initializeUiState()

        this@CaViewModel.uiState = remember {
            mutableStateOf(uiState)
        }

        return this@CaViewModel.uiState
    }

    override fun updateUiState(update: (US) -> US) {
        uiState.value = update(uiState.value)
    }

    override fun executeOnUiState(execute: (US) -> Unit) {
        execute(this.uiState.value)
    }
}
