package com.santukis.sample.featured

import androidx.navigation.NavGraphBuilder
import com.santukis.navigation.InputArguments
import com.santukis.navigation.NavigationGraph
import com.santukis.navigation.Router
import com.santukis.navigation.navigateToActivity
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
