package com.santukis.sample.featurec.landing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout
import com.santukis.ca.components.scaffold.states.ScreenConfigurationState

class FeatureCLandingScreen : Screen<FeatureCLandingState>() {

    @Composable
    override fun rememberScreenLayout(
        screenConfiguration: ScreenConfigurationState
    ): ScreenLayout<FeatureCLandingState> =
        remember {
            FeatureCLandingScreenLayout()
        }
}
