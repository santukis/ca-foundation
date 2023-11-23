package com.santukis.sample.featurea.landing.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.santukis.ca.components.scaffold.Action
import com.santukis.sample.featurea.landing.FeatureALandingNavigationAction.NavigateToFeatureB
import com.santukis.sample.featurea.landing.FeatureALandingNavigationAction.NavigateToFeatureC
import com.santukis.sample.featurea.landing.FeatureALandingNavigationAction.NavigateToFeatureD
import com.santukis.sample.featurea.landing.FeatureALandingNavigationAction.NavigateToSecondaryScreen
import com.santukis.sample.featurea.landing.FeatureALandingState
import com.santukis.sample.featurea.landing.navigation.FeatureAModel
import com.santukis.sample.featurea.landing.navigation.ToFeatureBArguments
import com.santukis.sample.featurea.landing.navigation.ToFeatureCArguments
import com.santukis.sample.featurea.landing.navigation.ToFeatureDArguments
import com.santukis.sample.featurea.landing.navigation.ToSecondaryScreenArguments

@Suppress("UnusedParameter")
@Composable
fun FeatureALandingScreenContent(
    featureDResult: String,
    state: FeatureALandingState,
    onActions: (Action) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Color.Cyan)
    ) {
        val model = rememberSaveable { mutableStateOf(FeatureAModel()) }

        Text(text = "Feature A Landing")

        Button(onClick = { onActions(NavigateToSecondaryScreen(ToSecondaryScreenArguments())) }) {
            Text(text = "Navigate to Secondary Screen")
        }

        Button(onClick = { onActions(NavigateToFeatureB(ToFeatureBArguments("Hello"))) }) {
            Text(text = "Navigate to Feature B")
        }

        Button(onClick = {
            onActions(
                NavigateToFeatureC(
                    ToFeatureCArguments(anyParam = "Hello") { result ->
                        model.value = result
                    }
                )
            )
        }) {
            Text(text = "Navigate to Feature C For Results")
        }

        Text(text = "Results From Feature C:\n${model.value}")

        Button(onClick = {
            onActions(NavigateToFeatureD(ToFeatureDArguments(anyParam = "Hello")))
        }) {
            Text(text = "Navigate to Feature D")
        }

        Text(text = "Results From Feature D:\n$featureDResult")
    }
}
