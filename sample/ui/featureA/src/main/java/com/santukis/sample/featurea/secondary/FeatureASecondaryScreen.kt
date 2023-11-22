package com.santukis.sample.featurea.secondary

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass.Companion.COMPACT
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.ScreenLayout

class FeatureASecondaryScreen : Screen<FeatureASecondaryState>() {

    @Composable
    override fun rememberScreenLayout(
        windowSizeClass: WindowSizeClass
    ): ScreenLayout<FeatureASecondaryState> =
        remember(windowSizeClass) {
            if (windowSizeClass.windowWidthSizeClass == COMPACT) {
                FeatureASecondaryPortraitScreenLayout()
            } else {
                FeatureASecondaryLandscapeScreenLayout()
            }
        }
}
