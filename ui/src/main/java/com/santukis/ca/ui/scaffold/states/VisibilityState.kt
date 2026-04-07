package com.santukis.ca.ui.scaffold.states

import com.santukis.ca.ui.scaffold.UiState

/**
 * Defines a contract for managing the visibility of a UI component.
 * It provides methods to check visibility, show, hide, and toggle the component's state.
 */
interface VisibilityState : UiState {

    /**
     * Checks if the component is currently visible.
     *
     * @return `true` if the component is visible, `false` otherwise.
     */
    fun isVisible(): Boolean

    /**
     * Makes the component visible.
     *
     * @param onShown A callback to be invoked after the component has been shown.
     */
    fun show(onShown: () -> Unit = {})

    /**
     * Hides the component.
     *
     * @param onHidden A callback to be invoked after the component has been hidden.
     */
    fun hide(onHidden: () -> Unit = {})

    /**
     * Toggles the visibility of the component.
     * If the component is visible, it will be hidden. If it is hidden, it will be shown.
     *
     * @param onShown A callback to be invoked if the component is shown.
     * @param onHidden A callback to be invoked if the component is hidden.
     */
    fun toggle(
        onShown: () -> Unit = {},
        onHidden: () -> Unit = {}
    ) {
        when {
            isVisible() -> hide(onHidden)
            else -> show(onShown)
        }
    }
}
