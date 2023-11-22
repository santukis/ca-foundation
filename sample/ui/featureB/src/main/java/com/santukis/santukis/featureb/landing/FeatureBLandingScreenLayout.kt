package com.santukis.santukis.featureb.landing

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScaffoldScreenLayout
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.santukis.featureb.landing.views.FeatureBLandingScreenContent
import com.santukis.santukis.featureb.landing.views.FeatureBSecondaryInputArguments

class FeatureBLandingScreenLayout : ScaffoldScreenLayout<FeatureBLandingState>() {

    @Composable
    override fun Content(
        arguments: ScreenArguments,
        state: FeatureBLandingState,
        onAction: (Action) -> Unit
    ) {
        FeatureBLandingScreenContent(
            anyParam = (arguments as? FeatureBSecondaryInputArguments)?.anyParam.orEmpty(),
            state = state,
            onActions = onAction
        )
    }
}
