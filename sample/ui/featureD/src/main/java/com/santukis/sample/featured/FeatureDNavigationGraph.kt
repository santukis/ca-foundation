package com.santukis.sample.featured

import androidx.navigation.NavGraphBuilder
import com.santukis.ca.ui.navigation.InputArguments
import com.santukis.ca.ui.navigation.NavigationGraph
import com.santukis.ca.ui.navigation.Router
import com.santukis.ca.ui.navigation.navigateToActivity
import com.santukis.sample.featured.host.FeatureDHostDestination

class FeatureDNavigationGraph : NavigationGraph {

    override fun NavGraphBuilder.buildGraph(
        router: Router,
        inputArguments: InputArguments
    ) {
        navigateToActivity(
            destination = FeatureDHostDestination()
        )
    }

    override fun getStartDestination(): String = ""
}
