package com.santukis.navigation

import androidx.compose.runtime.Stable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.activity
import androidx.navigation.compose.composable

@Stable
interface NavigationGraph {

    fun NavGraphBuilder.buildGraph(router: Router)

    fun getStartDestination(): String
}

@Stable
fun NavGraphBuilder.navigate(
    router: Router,
    destination: ScreenDestination
) {
    composable(
        route = destination.template,
        arguments = destination.getArguments(),
        deepLinks = destination.getDeepLinks()
    ) { backStackEntry ->
        destination.DestinationScreen(
            router = router,
            backStackEntry = backStackEntry
        )
    }
}

@Stable
fun NavGraphBuilder.navigateToActivity(
    destination: ActivityDestination
) {
    activity(
        route = destination.template
    ) {
        activityClass = destination.getActivityDestination()
    }
}
