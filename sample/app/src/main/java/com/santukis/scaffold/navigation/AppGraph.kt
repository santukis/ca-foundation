package com.santukis.scaffold.navigation

import androidx.navigation.NavGraphBuilder
import com.santukis.navigation.NavigationGraph
import com.santukis.navigation.Router

class AppGraph(private val dependentGraphs: List<NavigationGraph>) : NavigationGraph {

    override fun NavGraphBuilder.buildGraph(router: Router) {
        dependentGraphs.forEach { navigationGraph ->
            with(navigationGraph) {
                buildGraph(router)
            }
        }
    }
}
