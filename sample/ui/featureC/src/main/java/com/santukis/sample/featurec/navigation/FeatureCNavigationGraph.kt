package com.santukis.sample.featurec.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.santukis.navigation.NavigationGraph
import com.santukis.navigation.Router
import com.santukis.navigation.navigate
import com.santukis.sample.featurec.navigation.destinations.FeatureCLandingDestination

class FeatureCNavigationGraph : NavigationGraph {

    override fun NavGraphBuilder.buildGraph(router: Router) {
        navigation(
            startDestination = FeatureCLandingDestination.template,
            route = getStartDestination(),
        ) {
            navigate(
                router = router,
                destination = FeatureCLandingDestination
            )
        }
    }

    override fun getStartDestination(): String = "FeatureCNavigationGraph"
}
