package com.santukis.sample.featurea.secondary

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavBackStackEntry
import com.santukis.navigation.Router
import com.santukis.navigation.ScreenDestination
import com.santukis.sample.featurea.secondary.FeatureASecondaryNavigationAction.GoBack

class FeatureASecondaryDestination : ScreenDestination {

    override val template: String = "featureA/secondary"

    @Composable
    override fun DestinationScreen(
        router: Router,
        backStackEntry: NavBackStackEntry
    ) {
        val screen = remember { FeatureASecondaryScreen() }

        screen.Layout { action ->
            when (action) {
                is GoBack -> router.popBackStack()
            }
        }
    }
}
