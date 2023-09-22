package com.santukis.scaffold.landing.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.santukis.navigation.NavigationGraph
import com.santukis.navigation.Router
import org.koin.compose.koinInject

@Composable
fun AppLandingScreenContent(
    modifier: Modifier = Modifier,
    router: Router = koinInject(),
    navigationGraph: NavigationGraph = koinInject()
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        NavHost(
            navController = router.getNavController(),
            startDestination = navigationGraph.getStartDestination()
        ) {
            with(navigationGraph) {
                buildGraph(router)
            }
        }
    }
}
