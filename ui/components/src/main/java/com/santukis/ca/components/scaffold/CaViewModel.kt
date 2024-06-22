package com.santukis.ca.components.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel

abstract class CaViewModel<S : ScreenState, US : UiState> : ViewModel(), ActionHandler {

    private lateinit var state: MutableState<S>

    private lateinit var uiState: MutableState<US>

    abstract fun initializeState(): S

    @Composable
    abstract fun initializeUiState(): US

    @Composable
    fun rememberState(): State<S> {
        val state = initializeState()

        this@CaViewModel.state = remember {
            mutableStateOf(state)
        }

        return this@CaViewModel.state
    }

    fun updateState(update: (S) -> S) {
        state.value = update(state.value)
    }

    fun executeOnState(state: (S) -> Unit) {
        state(this.state.value)
    }

    @Composable
    fun rememberUiState(): State<US> {
        val uiState = initializeUiState()

        this@CaViewModel.uiState = remember {
            mutableStateOf(uiState)
        }

        return this@CaViewModel.uiState
    }

    fun updateUiState(update: (US) -> US) {
        uiState.value = update(uiState.value)
    }

    fun executeOnUiState(uiState: (US) -> Unit) {
        uiState(this.uiState.value)
    }
}
