package com.santukis.ca.components.scaffold.states

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun rememberVisibleState(
    initialValue: VisibilityState.VisibleValue = VisibilityState.VisibleValue.Visible
): VisibilityState =
    rememberSaveable(saver = VisibilityState.Saver) {
        VisibilityState(initialValue)
    }

@Suppress("NotCloseable")
@Stable
class VisibilityState(
    initialValue: VisibleValue
) {

    enum class VisibleValue {
        Visible,
        Invisible
    }

    private var currentValue: VisibleValue by mutableStateOf(initialValue)

    val isVisible: Boolean
        get() = currentValue == VisibleValue.Visible

    val isInvisible: Boolean
        get() = currentValue == VisibleValue.Invisible

    fun show() {
        currentValue = VisibleValue.Visible
    }

    fun hide() {
        currentValue = VisibleValue.Invisible
    }

    fun toggle() {
        when {
            isVisible -> hide()
            else -> show()
        }
    }

    companion object {
        val Saver: Saver<VisibilityState, VisibleValue> = Saver(
            save = { it.currentValue },
            restore = { VisibilityState(it) }
        )
    }
}
