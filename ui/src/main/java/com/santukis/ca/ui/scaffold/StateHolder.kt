package com.santukis.ca.ui.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State

/**
 * Defines a contract for a component that holds state for a screen.
 * It provides methods to initialize and remember the state and UI state.
 *
 * @param S The type of the screen state.
 * @param US The type of the UI state.
 */
interface StateHolder<S : ScreenState, US : UiState>: ActionHandler {

    /**
     * Initializes the screen state.
     *
     * @return The initial screen state.
     */
    fun initializeState(): S

    /**
     * Initializes the UI state within a Composable context.
     *
     * @return The initial UI state.
     */
    @Composable
    fun initializeUiState(): US
}
