package com.santukis.sample.featured.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.santukis.navigation.NavigationArguments
import com.santukis.sample.featured.navitation.arguments.ToFeatureAResultArguments

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeatureDLandingScreen(
    anyParam: String,
    navigateTo: (NavigationArguments) -> Unit,
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
            navigateTo(
                ToFeatureAResultArguments(inputText.value)
            )
        }) {
            Text(text = "Navigate to Feature A with Result")
        }

        Text(text = "Results that should be sent to Feature A: ${inputText.value}")
    }
}
