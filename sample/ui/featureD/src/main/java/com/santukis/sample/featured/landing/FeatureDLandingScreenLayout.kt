package com.santukis.sample.featured.landing

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScaffoldScreenLayout
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.sample.featured.landing.views.FeatureDLandingInputArguments
import com.santukis.sample.featured.landing.views.FeatureDLandingScreenContent

class FeatureDLandingScreenLayout : ScaffoldScreenLayout<FeatureDLandingState>() {

    @Composable
    override fun Content(
        arguments: ScreenArguments,
        state: FeatureDLandingState,
        onAction: (Action) -> Unit
    ) {
        FeatureDLandingScreenContent(
            anyParam = (arguments as? FeatureDLandingInputArguments)?.anyParam.orEmpty(),
            state = state,
            onActions = onAction
        )
    }
}
