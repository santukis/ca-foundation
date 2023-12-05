package com.santukis.sample.featurea.landing

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.screenlayouts.ScaffoldScreenLayout
import com.santukis.sample.featurea.landing.views.FeatureALandingInputArguments
import com.santukis.sample.featurea.landing.views.FeatureALandingScreenContent

class FeatureALandingScreenLayout : ScaffoldScreenLayout<FeatureALandingState>() {

    @Composable
    override fun BoxScope.Content(
        arguments: ScreenArguments,
        state: FeatureALandingState,
        onAction: (Action) -> Unit
    ) {
        FeatureALandingScreenContent(
            featureDResult = (arguments as? FeatureALandingInputArguments)?.anyParam.orEmpty(),
            state = state,
            onActions = onAction,
            modifier = Modifier
                .align(Alignment.Center)
                .verticalScroll(rememberScrollState())
        )
    }
}
