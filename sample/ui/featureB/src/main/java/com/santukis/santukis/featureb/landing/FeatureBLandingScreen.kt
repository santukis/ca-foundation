package com.santukis.santukis.featureb.landing

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout
import com.santukis.ca.components.scaffold.states.ScaffoldState
import com.santukis.ca.components.scaffold.states.rememberScaffoldState

class FeatureBLandingScreen : Screen<FeatureBLandingState, ScaffoldState>() {

    override fun screenLayout(
        state: FeatureBLandingState,
        uiState: ScaffoldState
    ): ScreenLayout<FeatureBLandingState, ScaffoldState> =
        FeatureBLandingScreenLayout()

    @Composable
    override fun uiState(): ScaffoldState = rememberScaffoldState()
}
