package com.santukis.sample.featurea

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.santukis.ca.ui.navigation.InputArguments
import com.santukis.ca.ui.navigation.NavigationGraph
import com.santukis.ca.ui.navigation.Router
import com.santukis.ca.ui.navigation.navigate
import com.santukis.sample.featurea.landing.FeatureALandingDestination
import com.santukis.sample.featurea.landing.navigation.FeatureALandingDestinationTemplate
import com.santukis.sample.featurea.secondary.FeatureASecondaryDestination

class FeatureANavigationGraph : NavigationGraph {

    override fun NavGraphBuilder.buildGraph(
        router: Router,
        inputArguments: InputArguments
    ) {
        navigation(
            startDestination = FeatureALandingDestinationTemplate().template,
            route = getStartDestination(),
        ) {
            navigate(
                destination = FeatureALandingDestination(
                    router = router
                ),
                inputArguments = inputArguments
            )

            navigate(
                destination = FeatureASecondaryDestination(
                    router = router
                ),
                inputArguments = inputArguments
            )
        }
    }

    override fun getStartDestination(): String = "FeatureANavigationGraph"
}
