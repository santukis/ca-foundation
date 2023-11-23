package com.santukis.santukis.featureb.secondary

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout
import com.santukis.ca.components.scaffold.states.ScreenConfigurationState

class FeatureBSecondaryScreen : Screen<FeatureBSecondaryState>() {

    @Composable
    override fun rememberScreenLayout(
        screenConfiguration: ScreenConfigurationState
    ): ScreenLayout<FeatureBSecondaryState> =
        remember {
            FeatureBSecondaryScreenLayout()
        }
}
