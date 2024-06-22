package com.santukis.santukis.featureb.landing

import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout
import com.santukis.ca.components.scaffold.states.ScaffoldState

class FeatureBLandingScreen : Screen<FeatureBLandingState, ScaffoldState>() {

    override fun screenLayout(
        state: FeatureBLandingState,
        uiState: ScaffoldState
    ): ScreenLayout<FeatureBLandingState, ScaffoldState> =
        FeatureBLandingScreenLayout()
}
