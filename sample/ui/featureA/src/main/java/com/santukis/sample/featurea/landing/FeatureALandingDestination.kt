package com.santukis.sample.featurea.landing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.santukis.navigation.Router
import com.santukis.navigation.ScreenDestination
import com.santukis.sample.featurea.landing.FeatureALandingNavigationAction.NavigateToFeatureB
import com.santukis.sample.featurea.landing.FeatureALandingNavigationAction.NavigateToFeatureC
import com.santukis.sample.featurea.landing.FeatureALandingNavigationAction.NavigateToFeatureD
import com.santukis.sample.featurea.landing.FeatureALandingNavigationAction.NavigateToSecondaryScreen
import com.santukis.sample.featurea.landing.views.FeatureALandingInputArguments

class FeatureALandingDestination : ScreenDestination {

    private companion object {
        const val FEATURE_D_RESULT = "result"
    }

    override val template: String = "featureA/landing?result={result}"

    override fun getArguments(): List<NamedNavArgument> =
        listOf(
            navArgument(FEATURE_D_RESULT) {
                type = NavType.StringType
            }
        )

    @Composable
    override fun DestinationScreen(
        router: Router,
        backStackEntry: NavBackStackEntry
    ) {
        val screen = remember { FeatureALandingScreen() }

        screen.Layout(
            arguments = FeatureALandingInputArguments(
                backStackEntry.arguments?.getString(FEATURE_D_RESULT).orEmpty()
            )
        ) { action ->
            when (action) {
                is NavigateToFeatureB -> router.navigate(action.arguments)
                is NavigateToFeatureC -> router.navigateForResult(action.arguments)
                is NavigateToFeatureD -> router.navigate(action.arguments)
                is NavigateToSecondaryScreen -> router.navigate(action.arguments)
            }
        }
    }
}
