package com.santukis.sample.featured.landing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.window.core.layout.WindowSizeClass
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.ScreenLayout

class FeatureDLandingScreen : Screen<FeatureDLandingState>() {

    @Composable
    override fun rememberScreenLayout(
        windowSizeClass: WindowSizeClass
    ): ScreenLayout<FeatureDLandingState> = remember {
        FeatureDLandingScreenLayout()
    }
}
