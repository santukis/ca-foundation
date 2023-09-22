package com.santukis.sample.featurea.secondary.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.santukis.ca.components.scaffold.Action
import com.santukis.sample.featurea.secondary.FeatureASecondaryNavigationAction.GoBack
import com.santukis.sample.featurea.secondary.FeatureASecondaryState

@Suppress("UnusedParameter")
@Composable
fun FeatureASecondaryScreenContent(
    state: FeatureASecondaryState,
    onAction: (Action) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(text = "Feature A Secondary Screen")
        Button(onClick = { onAction(GoBack()) }) {
            Text(text = "Navigate to Landing")
        }
    }
}
