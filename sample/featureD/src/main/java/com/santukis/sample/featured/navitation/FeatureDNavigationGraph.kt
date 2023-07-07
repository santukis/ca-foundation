package com.santukis.sample.featured.navitation

import androidx.navigation.NavGraphBuilder
import com.santukis.navigation.NavigationGraph
import com.santukis.navigation.Router
import com.santukis.navigation.navigateToActivity
import com.santukis.sample.featured.navitation.destinations.FeatureDLandingDestination

class FeatureDNavigationGraph : NavigationGraph {

    override fun NavGraphBuilder.buildGraph(router: Router) {
        navigateToActivity(
            destination = FeatureDLandingDestination
        )
    }
}
