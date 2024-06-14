package com.santukis.ca.components.scaffold.states

interface VisibilityState {

    fun isVisible(): Boolean

    fun show(onShown: () -> Unit = {})

    fun hide(onHidden: () -> Unit = {})

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
