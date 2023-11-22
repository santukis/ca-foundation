package com.santukis.santukis.featureb.landing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.window.core.layout.WindowSizeClass
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.ScreenLayout

class FeatureBLandingScreen : Screen<FeatureBLandingState>() {

    @Composable
    override fun rememberScreenLayout(
        windowSizeClass: WindowSizeClass
    ): ScreenLayout<FeatureBLandingState> =
        remember {
            FeatureBLandingScreenLayout()
        }
}
