package com.santukis.sample.featurec

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.santukis.navigation.InputArguments
import com.santukis.navigation.NavigationGraph
import com.santukis.navigation.Router
import com.santukis.navigation.navigate
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
