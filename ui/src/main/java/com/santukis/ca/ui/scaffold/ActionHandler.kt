package com.santukis.ca.ui.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.ui.platform.LocalContext

/**
 * Defines a contract for components that handle [Action]s.
 * It provides a mechanism to subscribe to an [ActionBus] and to execute actions.
 */
@Stable
interface ActionHandler {

    /**
     * Initializes the handler within a Composable context.
     * It subscribes the handler to the [ActionBus] when the Composable enters the composition
     * and unsubscribes it when it leaves the composition.
     */
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

    /**
     * Handles the given [action].
     * This method is called by the [ActionBus] when an action is dispatched.
     *
     * @param action The [Action] to handle.
     */
    fun handle(action: Action)

    /**
     * Dispatches an [action] to the [ActionBus] for handling.
     *
     * @param action The [Action] to execute.
     */
    fun execute(action: Action) {
        ActionBus.handle(action)
    }
}

/**
 * An internal object that acts as a central bus for dispatching and handling [Action]s.
 * It maintains a collection of subscribed [ActionHandler]s.
 */
internal object ActionBus {

    private val actionHandlers: MutableMap<Int, ActionHandler> = mutableMapOf()

    /**
     * Subscribes an [ActionHandler] to receive actions.
     *
     * @param actionHandler The handler to subscribe.
     */
    fun subscribeHandler(actionHandler: ActionHandler) {
        actionHandlers[System.identityHashCode(actionHandler)] = actionHandler
    }

    /**
     * Unsubscribes an [ActionHandler] from receiving actions.
     *
     * @param actionHandler The handler to unsubscribe.
     */
    fun unsubscribeHandler(actionHandler: ActionHandler) {
        actionHandlers.remove(System.identityHashCode(actionHandler))
    }

    /**
     * Dispatches an [action] to all subscribed [ActionHandler]s.
     *
     * @param action The action to handle.
     */
    fun handle(action: Action) {
        actionHandlers.forEach { entry -> entry.value.handle(action) }
    }
}
