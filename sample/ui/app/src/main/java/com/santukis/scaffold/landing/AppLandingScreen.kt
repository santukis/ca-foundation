package com.santukis.scaffold.landing

import com.santukis.ca.ui.scaffold.Screen
import com.santukis.ca.ui.scaffold.screenlayouts.NavigationScreenLayout
import com.santukis.ca.ui.scaffold.screenlayouts.ScreenLayout
import com.santukis.ca.ui.scaffold.states.NavigationState

class AppLandingScreen : Screen<AppLandingState, NavigationState>() {

    override fun screenLayout(
        state: AppLandingState,
        uiState: NavigationState
    ): ScreenLayout<AppLandingState, NavigationState> = NavigationScreenLayout()

}
