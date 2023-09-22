package com.santukis.sample.featured

import androidx.navigation.NavGraphBuilder
import com.santukis.navigation.NavigationGraph
import com.santukis.navigation.Router
import com.santukis.navigation.navigateToActivity
import com.santukis.sample.featured.landing.FeatureDLandingDestination

class FeatureDNavigationGraph : NavigationGraph {

    override fun NavGraphBuilder.buildGraph(router: Router) {
        navigateToActivity(
            destination = FeatureDLandingDestination
        )
    }

    override fun getStartDestination(): String = ""
}
