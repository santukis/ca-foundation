package com.santukis.sample.featured.landing.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.santukis.ca.ui.scaffold.Action
import com.santukis.sample.featured.landing.FeatureDLandingNavigationAction.NavigateToFeatureAScreen
import com.santukis.sample.featured.landing.FeatureDLandingState
import com.santukis.sample.featured.landing.navigation.ToFeatureADestinationArguments

@Suppress("UnusedParameter")
@Composable
fun FeatureDLandingScreenContent(
    anyParam: String,
    state: FeatureDLandingState,
    onActions: (Action) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        val inputText = remember { mutableStateOf("") }

        Text(text = "Feature D Landing, $anyParam")

        TextField(
            value = inputText.value,
            onValueChange = { text -> inputText.value = text }
        )

        Button(onClick = {
            onActions(
                NavigateToFeatureAScreen(
                    ToFeatureADestinationArguments(inputText.value)
                )
            )
        }) {
            Text(text = "Navigate to Feature A with Result")
        }

        Text(text = "Results that should be sent to Feature A: ${inputText.value}")
    }
}
