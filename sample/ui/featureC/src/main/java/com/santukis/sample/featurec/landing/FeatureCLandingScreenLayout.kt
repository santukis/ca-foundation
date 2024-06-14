package com.santukis.sample.featurec.landing

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.screenlayouts.ScaffoldScreenLayout
import com.santukis.ca.components.scaffold.states.ScaffoldState
import com.santukis.sample.featurec.landing.views.FeatureCLandingInputArguments
import com.santukis.sample.featurec.landing.views.FeatureCLandingScreenContent

class FeatureCLandingScreenLayout : ScaffoldScreenLayout<FeatureCLandingState, ScaffoldState>() {

    @Composable
    override fun Content(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: FeatureCLandingState,
        uiState: ScaffoldState,
        onAction: (Action) -> Unit
    ) {
        FeatureCLandingScreenContent(
            anyParam = (arguments as? FeatureCLandingInputArguments)?.anyParam.orEmpty(),
            state = state,
            onActions = onAction
        )
    }
}
