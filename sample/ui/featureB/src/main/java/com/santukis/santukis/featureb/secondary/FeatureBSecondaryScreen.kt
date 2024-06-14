package com.santukis.santukis.featureb.secondary

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout
import com.santukis.ca.components.scaffold.states.ScaffoldState
import com.santukis.ca.components.scaffold.states.rememberScaffoldState

class FeatureBSecondaryScreen : Screen<FeatureBSecondaryState, ScaffoldState>() {

    override fun screenLayout(
        state: FeatureBSecondaryState,
        uiState: ScaffoldState
    ): ScreenLayout<FeatureBSecondaryState, ScaffoldState> =
        FeatureBSecondaryScreenLayout()

    @Composable
    override fun uiState(): ScaffoldState = rememberScaffoldState()
}
