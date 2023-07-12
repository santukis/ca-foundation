package com.santukis.sample.featurea.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.santukis.navigation.NavigationGraph
import com.santukis.navigation.Router
import com.santukis.navigation.navigate
import com.santukis.sample.featurea.navigation.destinations.FeatureALandingDestination
import com.santukis.sample.featurea.navigation.destinations.FeatureASecondaryDestination

class FeatureANavigationGraph : NavigationGraph {

    override fun NavGraphBuilder.buildGraph(router: Router) {
        navigation(
            startDestination = FeatureALandingDestination.template,
            route = getStartDestination(),
        ) {
            navigate(
                router = router,
                destination = FeatureALandingDestination
            )

            navigate(
                router = router,
                destination = FeatureASecondaryDestination()
            )
        }
    }

    override fun getStartDestination(): String = "FeatureANavigationGraph"
}
