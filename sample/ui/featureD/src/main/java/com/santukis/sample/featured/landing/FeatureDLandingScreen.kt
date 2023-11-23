package com.santukis.sample.featured.landing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout
import com.santukis.ca.components.scaffold.states.ScreenConfigurationState

class FeatureDLandingScreen : Screen<FeatureDLandingState>() {

    @Composable
    override fun rememberScreenLayout(
        screenConfiguration: ScreenConfigurationState
    ): ScreenLayout<FeatureDLandingState> = remember {
        FeatureDLandingScreenLayout()
    }
}
