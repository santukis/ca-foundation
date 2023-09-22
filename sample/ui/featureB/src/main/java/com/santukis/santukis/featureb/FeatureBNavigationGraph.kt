package com.santukis.santukis.featureb

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.santukis.navigation.NavigationGraph
import com.santukis.navigation.Router
import com.santukis.navigation.navigate
import com.santukis.santukis.featureb.landing.FeatureBLandingDestination
import com.santukis.santukis.featureb.secondary.FeatureBSecondaryDestination

class FeatureBNavigationGraph : NavigationGraph {

    override fun NavGraphBuilder.buildGraph(router: Router) {
        navigation(
            startDestination = FeatureBLandingDestination.template,
            route = getStartDestination(),
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

    override fun getStartDestination(): String = "FeatureBNavigationGraph"
}
