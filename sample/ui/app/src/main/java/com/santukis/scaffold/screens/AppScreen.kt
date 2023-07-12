package com.santukis.scaffold.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.santukis.navigation.rememberRouter
import com.santukis.sample.featurea.navigation.FeatureANavigationGraph
import com.santukis.sample.featurec.navigation.FeatureCNavigationGraph
import com.santukis.sample.featured.navitation.FeatureDNavigationGraph
import com.santukis.santukis.featureb.navigation.FeatureBNavigationGraph
import com.santukis.scaffold.navigation.AppArgumentsMapper
import com.santukis.scaffold.navigation.AppGraph

@Composable
fun AppScreen(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val router = rememberRouter(
        argumentsMapper = remember { AppArgumentsMapper() },
        navController = navController
    )
    val appGraph = remember {
        AppGraph(
            listOf(
                FeatureANavigationGraph(),
                FeatureBNavigationGraph(),
                FeatureCNavigationGraph(),
                FeatureDNavigationGraph()
            )
        )
    }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            modifier = Modifier.navigationBarsPadding(),
            scaffoldState = rememberScaffoldState()
        ) { paddingValues ->
            NavHost(
                modifier = Modifier
                    .padding(paddingValues),
                navController = navController,
                startDestination = appGraph.getStartDestination()
            ) {
                with(appGraph) {
                    buildGraph(router)
                }
            }
        }
    }
}
