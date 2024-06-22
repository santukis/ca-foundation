package com.santukis.sample.featured.landing

import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout
import com.santukis.ca.components.scaffold.states.ScaffoldState

class FeatureDLandingScreen : Screen<FeatureDLandingState, ScaffoldState>() {

    override fun screenLayout(
        state: FeatureDLandingState,
        uiState: ScaffoldState
    ): ScreenLayout<FeatureDLandingState, ScaffoldState> =
        FeatureDLandingScreenLayout()
}
