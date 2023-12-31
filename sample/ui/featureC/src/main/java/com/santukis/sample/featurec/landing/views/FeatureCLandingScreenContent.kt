package com.santukis.sample.featurec.landing.views

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
import com.santukis.ca.components.scaffold.Action
import com.santukis.sample.featurec.landing.FeatureCLandingNavigationAction.NavigateToFeatureAScreen
import com.santukis.sample.featurec.landing.FeatureCLandingState
import com.santukis.sample.featurec.landing.navigation.FeatureCModel
import com.santukis.sample.featurec.landing.navigation.ToFeatureAResultArguments

@Suppress("UnusedParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeatureCLandingScreenContent(
    anyParam: String,
    state: FeatureCLandingState,
    onActions: (Action) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        var model by remember { mutableStateOf(FeatureCModel()) }

        Text(text = "Feature C Landing, $anyParam")

        TextField(
            value = model.field1,
            onValueChange = { model = model.copy(field1 = it) }
        )
        TextField(
            value = model.field2,
            onValueChange = { model = model.copy(field2 = it) }
        )
        TextField(
            value = model.field3,
            onValueChange = { model = model.copy(field3 = it) }
        )

        Button(onClick = {
            onActions(
                NavigateToFeatureAScreen(
                    ToFeatureAResultArguments(model)
                )
            )
        }) {
            Text(text = "Navigate to Feature A with Result")
        }

        Text(text = "Results that should be sent to Feature A:\n$model")
    }
}
