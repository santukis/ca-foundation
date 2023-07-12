package com.santukis.sample.featurea.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.santukis.navigation.NavigationArguments
import com.santukis.navigation.PopBackStack

@Composable
fun FeatureASecondaryScreen(
    navigateTo: (NavigationArguments) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(text = "Feature A Secondary Screen")
        Button(onClick = { navigateTo(PopBackStack) }) {
            Text(text = "Navigate to Landing")
        }
    }
}
