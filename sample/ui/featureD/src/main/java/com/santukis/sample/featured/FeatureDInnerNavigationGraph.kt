package com.santukis.sample.featured

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.santukis.ca.ui.navigation.InputArguments
import com.santukis.ca.ui.navigation.NavigationGraph
import com.santukis.ca.ui.navigation.Router
import com.santukis.ca.ui.navigation.navigate
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
