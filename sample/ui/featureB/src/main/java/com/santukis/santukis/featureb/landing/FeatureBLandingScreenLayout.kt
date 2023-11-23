package com.santukis.santukis.featureb.landing

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.screenlayouts.ScaffoldScreenLayout
import com.santukis.santukis.featureb.landing.views.FeatureBLandingScreenContent
import com.santukis.santukis.featureb.landing.views.FeatureBSecondaryInputArguments

class FeatureBLandingScreenLayout : ScaffoldScreenLayout<FeatureBLandingState>() {

    @Composable
    override fun BoxScope.Content(
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
