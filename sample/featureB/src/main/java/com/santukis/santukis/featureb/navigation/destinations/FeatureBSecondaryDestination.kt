package com.santukis.santukis.featureb.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.santukis.navigation.Router
import com.santukis.navigation.ScreenDestination
import com.santukis.santukis.featureb.navigation.arguments.ToFeatureBLandingResultArguments
import com.santukis.santukis.featureb.screens.FeatureBSecondaryScreen

class FeatureBSecondaryDestination : ScreenDestination {

    override val template: String
        get() = "featureB/secondary"

    @Composable
    override fun DestinationScreen(
        router: Router,
        backStackEntry: NavBackStackEntry
    ) {
        FeatureBSecondaryScreen { arguments ->
            when(arguments) {
                is ToFeatureBLandingResultArguments -> router.setResult(arguments)
            }
        }
    }
}
