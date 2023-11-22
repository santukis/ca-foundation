package com.santukis.sample.featurec.landing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.window.core.layout.WindowSizeClass
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.ScreenLayout

class FeatureCLandingScreen : Screen<FeatureCLandingState>() {

    @Composable
    override fun rememberScreenLayout(
        windowSizeClass: WindowSizeClass
    ): ScreenLayout<FeatureCLandingState> =
        remember {
            FeatureCLandingScreenLayout()
        }
}
