package com.santukis.sample.featurea.landing

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.screenlayouts.ScaffoldScreenLayout
import com.santukis.ca.components.scaffold.states.ScaffoldState
import com.santukis.sample.featurea.landing.views.FeatureALandingInputArguments
import com.santukis.sample.featurea.landing.views.FeatureALandingScreenContent
import com.santukis.sample.featurea.landing.views.FeatureALandingTopBar

class FeatureALandingContentScreenLayout : ScaffoldScreenLayout<FeatureALandingState, ScaffoldState>() {

    @Composable
    override fun Content(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: FeatureALandingState,
        uiState: ScaffoldState,
        onAction: (Action) -> Unit
    ) {
        FeatureALandingScreenContent(
            featureDResult = (arguments as? FeatureALandingInputArguments)?.anyParam.orEmpty(),
            state = state,
            onActions = onAction,
            modifier = modifier
                .verticalScroll(rememberScrollState())
        )
    }

    @Composable
    override fun TopBar(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: FeatureALandingState,
        uiState: ScaffoldState,
        onAction: (Action) -> Unit
    ) {
        FeatureALandingTopBar(
            arguments = arguments,
            state = state,
            onAction = onAction
        )
    }
}
