package com.santukis.sample.featurea.secondary

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout
import com.santukis.sample.featurea.secondary.states.FeatureASecondaryScreenUiState
import com.santukis.sample.featurea.secondary.states.rememberFeatureASecondaryScreenUiState

class FeatureASecondaryScreen : Screen<FeatureASecondaryState, FeatureASecondaryScreenUiState>() {


    override fun screenLayout(
        state: FeatureASecondaryState,
        uiState: FeatureASecondaryScreenUiState
    ): ScreenLayout<FeatureASecondaryState, FeatureASecondaryScreenUiState> =
        when (uiState.screenConfigurationState.isPortrait()) {
            true -> FeatureASecondaryPortraitScreenLayout()
            false -> FeatureASecondaryLandscapeScreenLayout()
        }

    @Composable
    override fun uiState(): FeatureASecondaryScreenUiState =
        rememberFeatureASecondaryScreenUiState()
}
