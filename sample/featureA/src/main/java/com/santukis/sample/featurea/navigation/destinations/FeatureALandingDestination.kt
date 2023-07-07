package com.santukis.sample.featurea.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.santukis.navigation.DestinationArguments
import com.santukis.navigation.Router
import com.santukis.navigation.ScreenDestination
import com.santukis.sample.featurea.navigation.arguments.ToFeatureCArguments
import com.santukis.sample.featurea.navigation.arguments.ToFeatureDArguments
import com.santukis.sample.featurea.screens.FeatureALandingScreen

object FeatureALandingDestination : ScreenDestination {

    override val template: String = "featureA/landing"

    @Composable
    override fun DestinationScreen(
        router: Router,
        backStackEntry: NavBackStackEntry
    ) {
        FeatureALandingScreen(
            navigateTo = { arguments ->
                when (arguments) {
                    is ToFeatureCArguments -> router.navigateForResult(arguments)
                    is ToFeatureDArguments -> router.navigateForResult(arguments)
                    is DestinationArguments -> router.navigate(arguments)
                }
            }
        )
    }
}
