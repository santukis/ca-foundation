package com.santukis.santukis.featureb.landing.views

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
import com.santukis.ca.components.scaffold.Action
import com.santukis.santukis.featureb.landing.FeatureBLandingNavigationAction.GoBack
import com.santukis.santukis.featureb.landing.FeatureBLandingNavigationAction.NavigateToSecondaryScreen
import com.santukis.santukis.featureb.landing.FeatureBLandingState
import com.santukis.santukis.featureb.landing.navigation.ToSecondaryScreenArguments

@Suppress("UnusedParameter")
@Composable
fun FeatureBLandingScreenContent(
    anyParam: String,
    state: FeatureBLandingState,
    onActions: (Action) -> Unit,
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
            onActions(
                NavigateToSecondaryScreen(
                    ToSecondaryScreenArguments { result ->
                        secondaryScreenResult = result
                    }
                )
            )
        }) {
            Text(text = "Navigate to Secondary Screen For Result")
        }
        Button(onClick = { onActions(GoBack()) }) {
            Text(text = "Return to Feature A")
        }
    }
}
