package com.santukis.sample.featured

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.santukis.navigation.InputArguments
import com.santukis.navigation.NavigationGraph
import com.santukis.navigation.Router
import com.santukis.navigation.navigate
import com.santukis.sample.featured.landing.FeatureDLandingDestination
import com.santukis.sample.featured.landing.navigation.FeatureDLandingDestinationTemplate

class FeatureDInnerNavigationGraph : NavigationGraph {

    override fun NavGraphBuilder.buildGraph(
        router: Router,
        inputArguments: InputArguments
    ) {
        navigation(
            startDestination = FeatureDLandingDestinationTemplate().template,
            route = getStartDestination(),
        ) {
            navigate(
                destination = FeatureDLandingDestination(
                    router = router
                ),
                inputArguments = inputArguments
            )
        }
    }

    override fun getStartDestination(): String = "FeatureDInnerNavigationGraph"
}
