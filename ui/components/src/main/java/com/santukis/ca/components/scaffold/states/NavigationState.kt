package com.santukis.ca.components.scaffold.states

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.UiState
import com.santukis.injection.core.DependencyInjectorProvider
import com.santukis.navigation.ArgumentsMapper
import com.santukis.navigation.NavigationGraph
import com.santukis.navigation.Router
import com.santukis.navigation.rememberRouter

interface NavigationState : UiState {
    val router: Router
    val navigationGraph: NavigationGraph
}

@Composable
fun navigationState(
    router: Router = rememberRouter(
        argumentsMapper = DependencyInjectorProvider
            .getDependency(clazz = ArgumentsMapper::class)
    ),
    navigationGraph: NavigationGraph = DependencyInjectorProvider
        .getDependency(clazz = NavigationGraph::class)
): NavigationState {
    val screenConfigurationState = screenConfigurationState()

    return DefaultNavigationState(
        router = router,
        navigationGraph = navigationGraph,
        screenConfigurationState = screenConfigurationState
    )
}

internal class DefaultNavigationState(
    override val router: Router,
    override val navigationGraph: NavigationGraph,
    override val screenConfigurationState: ScreenConfigurationState
) : NavigationState
