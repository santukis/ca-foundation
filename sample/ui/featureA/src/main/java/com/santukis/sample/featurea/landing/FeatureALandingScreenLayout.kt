package com.santukis.sample.featurea.landing

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScaffoldScreenLayout
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.sample.featurea.landing.views.FeatureALandingInputArguments
import com.santukis.sample.featurea.landing.views.FeatureALandingScreenContent

class FeatureALandingScreenLayout : ScaffoldScreenLayout<FeatureALandingState>() {

    @Composable
    override fun Content(
        arguments: ScreenArguments,
        state: FeatureALandingState,
        onAction: (Action) -> Unit
    ) {
        FeatureALandingScreenContent(
            featureDResult = (arguments as? FeatureALandingInputArguments)?.anyParam.orEmpty(),
            state = state,
            onActions = onAction
        )
    }
}
