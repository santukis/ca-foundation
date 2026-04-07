package com.santukis.ca.ui.scaffold.states

import androidx.compose.runtime.Composable
import com.santukis.ca.ui.navigation.ArgumentsMapper
import com.santukis.ca.ui.navigation.NavigationGraph
import com.santukis.ca.ui.navigation.Router
import com.santukis.ca.ui.navigation.rememberRouter
import com.santukis.ca.ui.scaffold.UiState
import com.santukis.injection.core.DependencyInjectorProvider

/**
 * Represents the navigation-related UI state of a screen.
 *
 * It extends [UiState] and holds the necessary components for navigation,
 * such as the [Router] and the [NavigationGraph].
 *
 * @see UiState
 * @see Router
 * @see NavigationGraph
 */
interface NavigationState : UiState {
    /**
     * The router responsible for handling navigation commands.
     */
    val router: Router

    /**
     * The navigation graph for the current screen or feature.
     */
    val navigationGraph: NavigationGraph
}

/**
 * Creates and remembers a [NavigationState].
 *
 * This function provides a convenient way to create and manage navigation state within a Composable.
 * It uses dependency injection to get the required [ArgumentsMapper] and [NavigationGraph].
 *
 * @param router The [Router] to be used for navigation. Defaults to a remembered router instance.
 * @param navigationGraph The [NavigationGraph] for the screen. Defaults to an instance obtained
 * from the dependency injector.
 * @return A remembered instance of [NavigationState].
 */
@Composable
fun navigationState(
    router: Router = rememberRouter(
        argumentsMapper = DependencyInjectorProvider
            .getDependency(clazz = ArgumentsMapper::class)
    ),
    navigationGraph: NavigationGraph = DependencyInjectorProvider
        .getDependency(clazz = NavigationGraph::class)
): NavigationState =
     DefaultNavigationState(
        router = router,
        navigationGraph = navigationGraph,
    )

/**
 * The default implementation of [NavigationState].
 *
 * @param router The router for navigation.
 * @param navigationGraph The navigation graph.
 */
internal class DefaultNavigationState(
    override val router: Router,
    override val navigationGraph: NavigationGraph,
) : NavigationState
