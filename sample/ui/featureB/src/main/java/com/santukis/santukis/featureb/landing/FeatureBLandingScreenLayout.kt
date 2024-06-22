package com.santukis.santukis.featureb.landing

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.Action
import com.santukis.navigation.InputArguments
import com.santukis.ca.components.scaffold.screenlayouts.ScaffoldScreenLayout
import com.santukis.ca.components.scaffold.states.ScaffoldState
import com.santukis.santukis.featureb.landing.views.FeatureBLandingScreenContent
import com.santukis.santukis.featureb.landing.navigation.FeatureBSecondaryInputArguments

class FeatureBLandingScreenLayout : ScaffoldScreenLayout<FeatureBLandingState, ScaffoldState>() {

    @Composable
    override fun Content(
        modifier: Modifier,
        arguments: InputArguments,
        state: FeatureBLandingState,
        uiState: ScaffoldState,
        onAction: (Action) -> Unit
    ) {
        FeatureBLandingScreenContent(
            anyParam = arguments.getValue(FeatureBSecondaryInputArguments()).orEmpty(),
            state = state,
            onActions = onAction
        )
    }
}
