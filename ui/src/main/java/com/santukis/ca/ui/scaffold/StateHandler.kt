package com.santukis.ca.ui.scaffold

/**
 * Defines a contract for a component that manages state for a screen.
 * It provides methods to update, and execute operations on the screen state and UI state.
 *
 * @param S The type of the screen state.
 * @param US The type of the UI state.
 */
interface StateHandler<S : ScreenState, US : UiState>: ActionHandler {

    /**
     * Updates the screen state using the provided [update] lambda.
     *
     * @param update A lambda that takes the current state and returns the new state.
     */
    fun updateState(update: (S) -> S)

    /**
     * Executes a given [execute] lambda on the current screen state.
     *
     * @param execute A lambda to execute on the current screen state.
     */
    fun executeOnState(execute: (S) -> Unit)

    /**
     * Updates the UI state using the provided [update] lambda.
     *
     * @param update A lambda that takes the current UI state and returns the new state.
     */
    fun updateUiState(update: (US) -> US)

    /**
     * Executes a given [execute] lambda on the current UI state.
     *
     * @param execute A lambda to execute on the current UI state.
     */
    fun executeOnUiState(execute: (US) -> Unit)
}
