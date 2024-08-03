package com.santukis.ca.components.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State

interface StateHandler<S : ScreenState, US : UiState>: ActionHandler {

    fun initializeState(): S

    @Composable
    fun initializeUiState(): US

    @Composable
    fun rememberState(): State<S>

    fun updateState(update: (S) -> S)

    fun executeOnState(execute: (S) -> Unit)

    @Composable
    fun rememberUiState(): State<US>

    fun updateUiState(update: (US) -> US)

    fun executeOnUiState(execute: (US) -> Unit)
}