package com.santukis.sample.featured.host

import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.screenlayouts.NavigationScreenLayout
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout
import com.santukis.ca.components.scaffold.states.NavigationState

class FeatureDHostScreen : Screen<FeatureDHostState, NavigationState>() {

    override fun screenLayout(
        state: FeatureDHostState,
        uiState: NavigationState
    ): ScreenLayout<FeatureDHostState, NavigationState> =
        NavigationScreenLayout()
}
