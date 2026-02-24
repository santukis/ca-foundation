package com.santukis.ca.ui.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.ui.platform.LocalContext

@Stable
interface ActionHandler {

    @Composable
    fun InitializeHandler() {
        val key = LocalContext.current

        DisposableEffect(key1 = key) {
            ActionBus.subscribeHandler(actionHandler = this@ActionHandler)

            onDispose {
                ActionBus.unsubscribeHandler(actionHandler = this@ActionHandler)
            }
        }
    }

    fun handle(action: Action)

    fun execute(action: Action) {
        ActionBus.handle(action)
    }
}

internal object ActionBus {

    private val actionHandlers: MutableMap<Int, ActionHandler> = mutableMapOf()

    fun subscribeHandler(actionHandler: ActionHandler) {
        actionHandlers[System.identityHashCode(actionHandler)] = actionHandler
    }

    fun unsubscribeHandler(actionHandler: ActionHandler) {
        actionHandlers.remove(System.identityHashCode(actionHandler))
    }

    fun handle(action: Action) {
        actionHandlers.forEach { entry -> entry.value.handle(action) }
    }
}
