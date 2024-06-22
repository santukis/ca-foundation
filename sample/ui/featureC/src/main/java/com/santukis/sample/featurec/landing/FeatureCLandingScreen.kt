package com.santukis.sample.featurec.landing

import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout
import com.santukis.ca.components.scaffold.states.ScaffoldState

class FeatureCLandingScreen : Screen<FeatureCLandingState, ScaffoldState>() {

    override fun screenLayout(
        state: FeatureCLandingState,
        uiState: ScaffoldState
    ): ScreenLayout<FeatureCLandingState, ScaffoldState> =
        FeatureCLandingScreenLayout()

}
