package com.santukis.santukis.featureb.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.santukis.navigation.PopBackStack
import com.santukis.navigation.Router
import com.santukis.navigation.ScreenDestination
import com.santukis.santukis.featureb.navigation.arguments.ToSecondaryScreenArguments
import com.santukis.santukis.featureb.screens.FeatureBLandingScreen

object FeatureBLandingDestination : ScreenDestination {

    private const val ANY_PARAM_KEY = "anyParam"

    override val template: String
        get() = "featureB/landing/{$ANY_PARAM_KEY}"

    override fun getArguments(): List<NamedNavArgument> =
        listOf(
            navArgument(ANY_PARAM_KEY) {
                type = NavType.StringType
            }
        )

    @Composable
    override fun DestinationScreen(
        router: Router,
        backStackEntry: NavBackStackEntry
    ) {
        FeatureBLandingScreen(
            anyParam = backStackEntry.arguments?.getString(ANY_PARAM_KEY).orEmpty()
        ) { arguments ->

            when(arguments) {
                is ToSecondaryScreenArguments -> router.navigateForResult(arguments = arguments)
                is PopBackStack -> router.popBackStack()
            }
        }
    }
}
