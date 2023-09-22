package com.santukis.sample.featurec.landing

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.sample.featurec.landing.views.FeatureCLandingInputArguments
import com.santukis.sample.featurec.landing.views.FeatureCLandingScreenContent

class FeatureCLandingScreen : Screen<
    FeatureCLandingState,
    FeatureCLandingAction,
    FeatureCLandingNavigationAction<*>
    >() {

    @Composable
    override fun Content(
        arguments: ScreenArguments,
        state: FeatureCLandingState,
        onAction: (Action) -> Unit
    ) {
        FeatureCLandingScreenContent(
            anyParam = (arguments as? FeatureCLandingInputArguments)?.anyParam.orEmpty(),
            state = state,
            onActions = onAction
        )
    }
}
