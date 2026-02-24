package com.santukis.sample.featured.landing

import com.santukis.ca.ui.scaffold.Screen
import com.santukis.ca.ui.scaffold.screenlayouts.ScreenLayout
import com.santukis.ca.ui.scaffold.states.ScaffoldState

class FeatureDLandingScreen : Screen<FeatureDLandingState, ScaffoldState>() {

    override fun screenLayout(
        state: FeatureDLandingState,
        uiState: ScaffoldState
    ): ScreenLayout<FeatureDLandingState, ScaffoldState> =
        FeatureDLandingScreenLayout()
}
