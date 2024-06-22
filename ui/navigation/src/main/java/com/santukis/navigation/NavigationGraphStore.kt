package com.santukis.navigation

import androidx.navigation.NavGraphBuilder

interface NavigationGraphStore : NavigationGraph {

    fun addNavigationGraph(graph: NavigationGraph)
}

internal class DefaultNavigationGraphStore : NavigationGraphStore {

    private val dependentGraphs: MutableList<NavigationGraph> = mutableListOf()

    override fun addNavigationGraph(graph: NavigationGraph) {
        dependentGraphs.add(graph)
    }

    override fun NavGraphBuilder.buildGraph(
        router: Router,
        inputArguments: InputArguments
    ) {
        dependentGraphs.forEach { navigationGraph ->
            with(navigationGraph) {
                buildGraph(
                    router = router,
                    inputArguments = inputArguments
                )
            }
        }
    }

    override fun getStartDestination(): String =
        dependentGraphs.firstOrNull()?.getStartDestination().orEmpty()
}

object NavigationGraphStoreProvider {

    fun provide(): NavigationGraphStore = DefaultNavigationGraphStore()
}
