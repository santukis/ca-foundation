package com.santukis.sample.featurea.landing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.santukis.ca.ui.scaffold.Action
import com.santukis.ca.ui.navigation.InputArguments
import com.santukis.ca.ui.scaffold.screenlayouts.NavigationDrawerScreenLayout

class FeatureALandingScreenLayout : NavigationDrawerScreenLayout<
        FeatureALandingState, FeatureALandingUiState>() {

    @Composable
    override fun DrawerContent(
        modifier: Modifier,
        arguments: InputArguments,
        state: FeatureALandingState,
        uiState: FeatureALandingUiState,
        onAction: (Action) -> Unit
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(fraction = NavigationViewWidth)
                .fillMaxHeight()
                .background(Color.Gray)
        ) {
            Text(text = "Header")
            Text(text = "Body")
        }
    }

    @Composable
    override fun Content(
        modifier: Modifier,
        arguments: InputArguments,
        state: FeatureALandingState,
        uiState: FeatureALandingUiState,
        onAction: (Action) -> Unit
    ) {
        FeatureALandingContentScreenLayout()
            .Layout(
                modifier = modifier,
                arguments = arguments,
                state = state,
                uiState = uiState,
                onAction = onAction
            )
    }

    private companion object {
        const val NavigationViewWidth = 0.4f
    }
}
