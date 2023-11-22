package com.santukis.santukis.featureb.secondary

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.window.core.layout.WindowSizeClass
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.ScreenLayout

class FeatureBSecondaryScreen : Screen<FeatureBSecondaryState>() {

    @Composable
    override fun rememberScreenLayout(
        windowSizeClass: WindowSizeClass
    ): ScreenLayout<FeatureBSecondaryState> =
        remember {
            FeatureBSecondaryScreenLayout()
        }
}
