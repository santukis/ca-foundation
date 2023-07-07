package com.santukis.santukis.featureb.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.santukis.navigation.NavigationGraph
import com.santukis.navigation.Router
import com.santukis.navigation.navigate
import com.santukis.santukis.featureb.navigation.destinations.FeatureBLandingDestination
import com.santukis.santukis.featureb.navigation.destinations.FeatureBSecondaryDestination

class FeatureBNavigationGraph : NavigationGraph {

    override fun NavGraphBuilder.buildGraph(router: Router) {
        navigation(
            startDestination = FeatureBLandingDestination.template,
            route = "FeatureBNavigationGraph",
        ) {

            navigate(
                router = router,
                destination = FeatureBLandingDestination
            )

            navigate(
                router = router,
                destination = FeatureBSecondaryDestination()
            )
        }
    }
}