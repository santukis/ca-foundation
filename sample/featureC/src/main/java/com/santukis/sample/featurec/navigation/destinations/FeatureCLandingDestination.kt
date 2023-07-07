package com.santukis.sample.featurec.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.santukis.navigation.Router
import com.santukis.navigation.ScreenDestination
import com.santukis.sample.featurec.navigation.arguments.ToFeatureAResultArguments
import com.santukis.sample.featurec.screens.FeatureCLandingScreen

object FeatureCLandingDestination : ScreenDestination {

    private const val ANY_PARAM_KEY = "anyParam"

    override val template: String
        get() = "featureC/landing/{$ANY_PARAM_KEY}"

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
        FeatureCLandingScreen(
            anyParam = backStackEntry.arguments?.getString(ANY_PARAM_KEY).orEmpty(),
            navigateTo = { arguments ->

                when (arguments) {
                    is ToFeatureAResultArguments -> router.setResult(arguments = arguments)
                }
            }
        )
    }
}
