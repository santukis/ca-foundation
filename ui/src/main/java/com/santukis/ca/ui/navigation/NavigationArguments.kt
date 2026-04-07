package com.santukis.ca.ui.navigation

import androidx.compose.runtime.Stable

/**
 * A marker interface for all navigation-related arguments.
 */
@Stable
interface NavigationArguments

/**
 * Represents arguments required to navigate to a destination.
 */
interface DestinationArguments : NavigationArguments {

    /**
     * Returns the route for the destination.
     * The route is a string that identifies the destination in the navigation graph.
     * It can include placeholders for arguments.
     *
     * @return The route string.
     */
    fun getRoute(): String = ""
}

/**
 * A [DestinationArguments] object used to pop the current destination from the back stack.
 */
object PopBackStack : DestinationArguments

/**
 * Represents arguments for navigating to a destination that is expected to return a result.
 *
 * @param Result The type of the result expected.
 */
interface DestinationArgumentsForResult<Result> : DestinationArguments {

    /**
     * A callback that will be invoked when the destination returns a result.
     */
    val onResult: (Result) -> Unit
}

/**
 * Represents arguments used to deliver a a result back to the previous destination.
 *
 * @param Result The type of the result being passed back.
 */
interface ResultArguments<Result> : NavigationArguments {

    /**
     * The result value.
     */
    val result: Result
}
