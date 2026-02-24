package com.santukis.sample.featured.host

import com.santukis.ca.ui.scaffold.Screen
import com.santukis.ca.ui.scaffold.screenlayouts.NavigationScreenLayout
import com.santukis.ca.ui.scaffold.screenlayouts.ScreenLayout
import com.santukis.ca.ui.scaffold.states.NavigationState

class FeatureDHostScreen : Screen<FeatureDHostState, NavigationState>() {

    override fun screenLayout(
        state: FeatureDHostState,
        uiState: NavigationState
    ): ScreenLayout<FeatureDHostState, NavigationState> =
        NavigationScreenLayout()
}
