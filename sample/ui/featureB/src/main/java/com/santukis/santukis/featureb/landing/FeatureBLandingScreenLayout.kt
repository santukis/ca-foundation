package com.santukis.santukis.featureb.landing

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.screenlayouts.ScaffoldScreenLayout
import com.santukis.ca.components.scaffold.states.ScaffoldState
import com.santukis.santukis.featureb.landing.views.FeatureBLandingScreenContent
import com.santukis.santukis.featureb.landing.views.FeatureBSecondaryInputArguments

class FeatureBLandingScreenLayout : ScaffoldScreenLayout<FeatureBLandingState, ScaffoldState>() {

    @Composable
    override fun Content(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: FeatureBLandingState,
        uiState: ScaffoldState,
        onAction: (Action) -> Unit
    ) {
        FeatureBLandingScreenContent(
            anyParam = (arguments as? FeatureBSecondaryInputArguments)?.anyParam.orEmpty(),
            state = state,
            onActions = onAction
        )
    }
}
