package com.santukis.sample.featurea.landing

import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout

class FeatureALandingScreen : Screen<FeatureALandingState, FeatureALandingUiState>() {

    override fun screenLayout(
        state: FeatureALandingState,
        uiState: FeatureALandingUiState
    ): ScreenLayout<FeatureALandingState, FeatureALandingUiState> =
        FeatureALandingScreenLayout()
}
