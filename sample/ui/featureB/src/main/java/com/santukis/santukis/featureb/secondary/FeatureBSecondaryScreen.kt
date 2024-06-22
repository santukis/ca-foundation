package com.santukis.santukis.featureb.secondary

import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout
import com.santukis.ca.components.scaffold.states.ScaffoldState

class FeatureBSecondaryScreen : Screen<FeatureBSecondaryState, ScaffoldState>() {

    override fun screenLayout(
        state: FeatureBSecondaryState,
        uiState: ScaffoldState
    ): ScreenLayout<FeatureBSecondaryState, ScaffoldState> =
        FeatureBSecondaryScreenLayout()
}
