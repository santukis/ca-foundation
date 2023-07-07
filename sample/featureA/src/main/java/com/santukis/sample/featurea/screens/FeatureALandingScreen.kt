package com.santukis.sample.featurea.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.santukis.navigation.NavigationArguments
import com.santukis.sample.featurea.navigation.arguments.FeatureAModel
import com.santukis.sample.featurea.navigation.arguments.ToFeatureBArguments
import com.santukis.sample.featurea.navigation.arguments.ToFeatureCArguments
import com.santukis.sample.featurea.navigation.arguments.ToFeatureDArguments
import com.santukis.sample.featurea.navigation.arguments.ToSecondaryScreenArguments

@Composable
fun FeatureALandingScreen(
    navigateTo: (NavigationArguments) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        val model = rememberSaveable { mutableStateOf(FeatureAModel()) }
        val resultFromD = rememberSaveable { mutableStateOf("") }

        Text(text = "Feature A Landing")

        Button(onClick = { navigateTo(ToSecondaryScreenArguments()) }) {
            Text(text = "Navigate to Secondary Screen")
        }

        Button(onClick = { navigateTo(ToFeatureBArguments("Hello")) }) {
            Text(text = "Navigate to Feature B")
        }

        Button(onClick = {
            navigateTo(
                ToFeatureCArguments(
                    anyParam = "Hello"
                ) { result ->
                    model.value = result
                }
            )
        }) {
            Text(text = "Navigate to Feature C For Results")
        }

        Text(text = "Results From Feature C:\n${model.value}")

        Button(onClick = {
            navigateTo(
                ToFeatureDArguments(
                    anyParam = "Hello"
                ) { result ->
                    resultFromD.value = result
                }
            )
        }) {
            Text(text = "Navigate to Feature D")
        }

        Text(text = "Results From Feature D:\n${resultFromD.value}")
    }
}
