package com.santukis.ca.ui.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink

/**
 * Represents the template for a destination's route.
 */
interface DestinationTemplate {

    /**
     * The route template string.
     * This can contain placeholders for arguments in the format `{argName}`.
     * For example: "user/{userId}".
     */
    val template: String

    /**
     * Returns a list of [NamedNavArgument]s that are part of the route.
     *
     * @return A list of navigation arguments.
     */
    fun getArguments(): List<NamedNavArgument> = listOf()

    /**
     * Returns a list of [NavDeepLink]s that lead to this destination.
     *
     * @return A list of deep links.
     */
    fun getDeepLinks(): List<NavDeepLink> = listOf()
}
