package com.santukis.scaffold.landing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.window.core.layout.WindowSizeClass
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.ScreenLayout

class AppLandingScreen : Screen<AppLandingState>() {

    @Composable
    override fun rememberScreenLayout(
        windowSizeClass: WindowSizeClass
    ): ScreenLayout<AppLandingState> =
        remember {
            AppLandingScreenLayout()
        }
}
