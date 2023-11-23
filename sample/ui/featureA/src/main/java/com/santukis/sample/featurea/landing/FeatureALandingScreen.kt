package com.santukis.sample.featurea.landing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout
import com.santukis.ca.components.scaffold.states.ScreenConfigurationState

class FeatureALandingScreen : Screen<FeatureALandingState>() {

    @Composable
    override fun rememberScreenLayout(
        screenConfiguration: ScreenConfigurationState
    ): ScreenLayout<FeatureALandingState> =
        remember {
            FeatureALandingScreenLayout()
        }
}
