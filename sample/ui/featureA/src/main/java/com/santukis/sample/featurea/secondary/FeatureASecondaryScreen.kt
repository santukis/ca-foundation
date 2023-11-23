package com.santukis.sample.featurea.secondary

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout
import com.santukis.ca.components.scaffold.states.ScreenConfigurationState

class FeatureASecondaryScreen : Screen<FeatureASecondaryState>() {

    @Composable
    override fun rememberScreenLayout(
        screenConfiguration: ScreenConfigurationState
    ): ScreenLayout<FeatureASecondaryState> =
        remember(screenConfiguration) {
            if (screenConfiguration.isPortrait()) {
                FeatureASecondaryPortraitScreenLayout()
            } else {
                FeatureASecondaryLandscapeScreenLayout()
            }
        }
}
