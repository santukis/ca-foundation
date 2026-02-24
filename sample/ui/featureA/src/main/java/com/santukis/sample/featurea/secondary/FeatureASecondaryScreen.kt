package com.santukis.sample.featurea.secondary

import com.santukis.ca.ui.scaffold.Screen
import com.santukis.ca.ui.scaffold.screenlayouts.ScreenLayout
import com.santukis.sample.featurea.secondary.states.FeatureASecondaryScreenUiState

class FeatureASecondaryScreen : Screen<FeatureASecondaryState, FeatureASecondaryScreenUiState>() {


    override fun screenLayout(
        state: FeatureASecondaryState,
        uiState: FeatureASecondaryScreenUiState
    ): ScreenLayout<FeatureASecondaryState, FeatureASecondaryScreenUiState> =
        when (uiState.screenConfigurationState.isPortrait()) {
            true -> FeatureASecondaryPortraitScreenLayout()
            false -> FeatureASecondaryLandscapeScreenLayout()
        }
}
