package com.santukis.santukis.featureb.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.santukis.navigation.NavigationArguments
import com.santukis.navigation.PopBackStack
import com.santukis.santukis.featureb.navigation.arguments.ToSecondaryScreenArguments

@Composable
fun FeatureBLandingScreen(
    anyParam: String,
    navigateTo: (NavigationArguments) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        var secondaryScreenResult by rememberSaveable { mutableStateOf("") }

        Text(text = "Feature B Landing, $anyParam $secondaryScreenResult")
        Button(onClick = {
            navigateTo(
                ToSecondaryScreenArguments { result ->
                    secondaryScreenResult = result
                }
            )
        }) {
            Text(text = "Navigate to Secondary Screen For Result")
        }
        Button(onClick = { navigateTo(PopBackStack) }) {
            Text(text = "Return to Feature A")
        }
    }
}
