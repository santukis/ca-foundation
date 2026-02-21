package com.santukis.navigation

import androidx.compose.runtime.Stable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.activity
import androidx.navigation.compose.composable

@Stable
interface NavigationGraph {

    fun NavGraphBuilder.buildGraph(
        router: Router,
        inputArguments: InputArguments
    )

    fun getStartDestination(): String
}

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
