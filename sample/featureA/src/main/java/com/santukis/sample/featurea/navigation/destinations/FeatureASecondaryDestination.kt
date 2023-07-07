package com.santukis.sample.featurea.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.santukis.navigation.PopBackStack
import com.santukis.navigation.Router
import com.santukis.navigation.ScreenDestination
import com.santukis.sample.featurea.screens.FeatureASecondaryScreen

class FeatureASecondaryDestination : ScreenDestination {

    override val template: String = "featureA/secondary"

    @Composable
    override fun DestinationScreen(
        router: Router,
        backStackEntry: NavBackStackEntry
    ) {
        FeatureASecondaryScreen { arguments ->
            when (arguments) {
                is PopBackStack -> router.popBackStack()
            }
        }
    }
}
