package com.santukis.santukis.featureb.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.santukis.navigation.NavigationArguments
import com.santukis.santukis.featureb.navigation.arguments.ToFeatureBLandingResultArguments

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeatureBSecondaryScreen(
    navigateTo: (NavigationArguments) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        var inputText by remember { mutableStateOf("") }

        Text(text = "Feature B Secondary Screen")

        TextField(
            value = inputText,
            onValueChange = { inputText = it }
        )

        Button(onClick = { navigateTo(ToFeatureBLandingResultArguments(inputText)) }) {
            Text(text = "Navigate to Landing")
        }
    }
}
