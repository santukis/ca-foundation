package com.santukis.sample.featurec

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.santukis.ca.ui.navigation.InputArguments
import com.santukis.ca.ui.navigation.NavigationGraph
import com.santukis.ca.ui.navigation.Router
import com.santukis.ca.ui.navigation.navigate
import com.santukis.sample.featurec.landing.FeatureCLandingDestination
import com.santukis.sample.featurec.landing.navigation.FeatureCLandingDestinationTemplate

class FeatureCNavigationGraph : NavigationGraph {

    override fun NavGraphBuilder.buildGraph(
        router: Router,
        inputArguments: InputArguments
    ) {
        navigation(
            startDestination = FeatureCLandingDestinationTemplate().template,
            route = getStartDestination(),
        ) {
            navigate(
                destination = FeatureCLandingDestination(
                    router = router
                ),
                inputArguments = inputArguments
            )
        }
    }

    override fun getStartDestination(): String = "FeatureCNavigationGraph"
}
