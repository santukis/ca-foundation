package com.santukis.sample.featured.landing

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout
import com.santukis.ca.components.scaffold.states.ScaffoldState
import com.santukis.ca.components.scaffold.states.rememberScaffoldState

class FeatureDLandingScreen : Screen<FeatureDLandingState, ScaffoldState>() {

    override fun screenLayout(
        state: FeatureDLandingState,
        uiState: ScaffoldState
    ): ScreenLayout<FeatureDLandingState, ScaffoldState> =
        FeatureDLandingScreenLayout()

    @Composable
    override fun uiState(): ScaffoldState = rememberScaffoldState()
}
