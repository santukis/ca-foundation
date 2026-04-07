package com.santukis.ca.ui.navigation

import androidx.navigation.NavGraphBuilder

/**
 * A store for [NavigationGraph]s.
 * It allows adding multiple navigation graphs and building them into a single [NavGraphBuilder].
 */
interface NavigationGraphStore : NavigationGraph {

    /**
     * Adds a [NavigationGraph] to the store.
     *
     * @param graph The navigation graph to add.
     */
    fun addNavigationGraph(graph: NavigationGraph)
}

/**
 * The default implementation of [NavigationGraphStore].
 */
internal class DefaultNavigationGraphStore : NavigationGraphStore {

    private val dependentGraphs: MutableList<NavigationGraph> = mutableListOf()

    override fun addNavigationGraph(graph: NavigationGraph) {
        dependentGraphs.add(graph)
    }

    /**
     * Builds all the registered navigation graphs into the provided [NavGraphBuilder].
     */
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

    /**
     * Returns the start destination of the first registered navigation graph.
     */
    override fun getStartDestination(): String =
        dependentGraphs.firstOrNull()?.getStartDestination().orEmpty()
}

/**
 * Provides an instance of [NavigationGraphStore].
 */
object NavigationGraphStoreProvider {

    /**
     * Returns a new instance of [DefaultNavigationGraphStore].
     */
    fun provide(): NavigationGraphStore = DefaultNavigationGraphStore()
}
