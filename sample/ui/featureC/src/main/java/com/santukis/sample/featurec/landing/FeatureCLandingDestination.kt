package com.santukis.sample.featurec.landing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.santukis.navigation.Router
import com.santukis.navigation.ScreenDestination
import com.santukis.sample.featurec.landing.FeatureCLandingNavigationAction.NavigateToFeatureAScreen
import com.santukis.sample.featurec.landing.views.FeatureCLandingInputArguments

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
        val screen = remember { FeatureCLandingScreen() }

        screen.Layout(
            arguments = FeatureCLandingInputArguments(
                backStackEntry.arguments?.getString(ANY_PARAM_KEY).orEmpty()
            )
        ) { action ->
            when (action) {
                is NavigateToFeatureAScreen -> router.setResult(arguments = action.arguments)
            }
        }
    }
}
