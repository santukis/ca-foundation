package com.santukis.santukis.featureb

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.santukis.ca.ui.navigation.InputArguments
import com.santukis.ca.ui.navigation.NavigationGraph
import com.santukis.ca.ui.navigation.Router
import com.santukis.ca.ui.navigation.navigate
import com.santukis.santukis.featureb.landing.FeatureBLandingDestination
import com.santukis.santukis.featureb.landing.navigation.FeatureBLandingDestinationTemplate
import com.santukis.santukis.featureb.secondary.FeatureBSecondaryDestination

class FeatureBNavigationGraph : NavigationGraph {

    override fun NavGraphBuilder.buildGraph(
        router: Router,
        inputArguments: InputArguments
    ) {
        navigation(
            startDestination = FeatureBLandingDestinationTemplate().template,
            route = getStartDestination(),
        ) {
            navigate(
                destination = FeatureBLandingDestination(
                    router = router
                ),
                inputArguments = inputArguments
            )

            navigate(
                destination = FeatureBSecondaryDestination(
                    router = router
                ),
                inputArguments = inputArguments
            )
        }
    }

    override fun getStartDestination(): String = "FeatureBNavigationGraph"
}
