package com.santukis.santukis.featureb.secondary

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavBackStackEntry
import com.santukis.navigation.Router
import com.santukis.navigation.ScreenDestination
import com.santukis.santukis.featureb.secondary.FeatureBSecondaryNavigationAction.NavigateToFeatureBLanding

class FeatureBSecondaryDestination : ScreenDestination {

    override val template: String
        get() = "featureB/secondary"

    @Composable
    override fun DestinationScreen(
        router: Router,
        backStackEntry: NavBackStackEntry
    ) {
        val screen = remember { FeatureBSecondaryScreen() }

        screen.Layout { action ->
            when (action) {
                is NavigateToFeatureBLanding -> router.setResult(action.arguments)
            }
        }
    }
}
