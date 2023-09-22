package com.santukis.santukis.featureb.landing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.santukis.navigation.Router
import com.santukis.navigation.ScreenDestination
import com.santukis.santukis.featureb.landing.FeatureBLandingNavigationAction.GoBack
import com.santukis.santukis.featureb.landing.FeatureBLandingNavigationAction.NavigateToSecondaryScreen
import com.santukis.santukis.featureb.landing.views.FeatureBSecondaryInputArguments

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
        val screen = remember { FeatureBLandingScreen() }

        screen.Layout(
            arguments = FeatureBSecondaryInputArguments(
                backStackEntry.arguments?.getString(ANY_PARAM_KEY).orEmpty()
            )
        ) { action ->
            when (action) {
                is NavigateToSecondaryScreen -> router.navigateForResult(arguments = action.arguments)
                is GoBack -> router.popBackStack()
            }
        }
    }
}
