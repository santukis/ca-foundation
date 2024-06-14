package com.santukis.scaffold.landing

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.UiState
import com.santukis.ca.components.scaffold.rememberUiState
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout

class AppLandingScreen : Screen<AppLandingState, UiState>() {

    override fun screenLayout(
        state: AppLandingState,
        uiState: UiState
    ): ScreenLayout<AppLandingState, UiState> =
        AppLandingScreenLayout()

    @Composable
    override fun uiState(): UiState = rememberUiState()

}
