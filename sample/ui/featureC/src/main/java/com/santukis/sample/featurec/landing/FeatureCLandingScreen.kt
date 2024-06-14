package com.santukis.sample.featurec.landing

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout
import com.santukis.ca.components.scaffold.states.ScaffoldState
import com.santukis.ca.components.scaffold.states.rememberScaffoldState

class FeatureCLandingScreen : Screen<FeatureCLandingState, ScaffoldState>() {

    override fun screenLayout(
        state: FeatureCLandingState,
        uiState: ScaffoldState
    ): ScreenLayout<FeatureCLandingState, ScaffoldState> =
        FeatureCLandingScreenLayout()

    @Composable
    override fun uiState(): ScaffoldState = rememberScaffoldState()

}
