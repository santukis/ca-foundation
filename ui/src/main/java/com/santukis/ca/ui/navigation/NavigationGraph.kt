package com.santukis.ca.ui.navigation

import androidx.compose.runtime.Stable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.activity
import androidx.navigation.compose.composable

/**
 * Represents a navigation graph that can be built using a [NavGraphBuilder].
 * A navigation graph is a collection of destinations that a user can navigate to.
 */
@Stable
interface NavigationGraph {

    /**
     * Builds the navigation graph using the provided [NavGraphBuilder].
     *
     * @param router The [Router] used for navigation.
     * @param inputArguments The input arguments for the graph.
     */
    fun NavGraphBuilder.buildGraph(
        router: Router,
        inputArguments: InputArguments
    )

    /**
     * Returns the route of the start destination of the graph.
     *
     * @return The start destination route.
     */
    fun getStartDestination(): String
}

/**
 * Adds a composable destination to the [NavGraphBuilder].
 *
 * @param destination The [ComposableDestination] to add.
 * @param inputArguments The input arguments for the destination.
 */
@Stable
fun NavGraphBuilder.navigate(
    destination: ComposableDestination,
    inputArguments: InputArguments
) {
    composable(
        route = destination.template.template,
        arguments = destination.template.getArguments(),
        deepLinks = destination.template.getDeepLinks(),
        enterTransition = destination.enterTransition(),
        exitTransition = destination.exitTransition(),
        popEnterTransition = destination.popEnterTransition(),
        popExitTransition = destination.popExitTransition()
    ) { backStackEntry ->
        destination.DestinationScreen(
            arguments = inputArguments + ScreenArguments(
                arguments = backStackEntry.arguments
            )
        )
    }
}

/**
 * Adds an activity destination to the [NavGraphBuilder].
 *
 * @param destination The [ActivityDestination] to add.
 */
@Stable
fun NavGraphBuilder.navigateToActivity(
    destination: ActivityDestination
) {
    activity(
        route = destination.template.template
    ) {
        activityClass = destination.getActivityDestination()
    }
}
