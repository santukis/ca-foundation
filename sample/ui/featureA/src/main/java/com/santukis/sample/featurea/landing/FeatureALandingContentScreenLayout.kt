package com.santukis.sample.featurea.landing

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.Action
import com.santukis.navigation.InputArguments
import com.santukis.ca.components.scaffold.screenlayouts.ScaffoldScreenLayout
import com.santukis.ca.components.scaffold.states.ScaffoldState
import com.santukis.sample.featurea.landing.navigation.FeatureALandingInputArguments
import com.santukis.sample.featurea.landing.views.FeatureALandingScreenContent
import com.santukis.sample.featurea.landing.views.FeatureALandingTopBar

class FeatureALandingContentScreenLayout :
    ScaffoldScreenLayout<FeatureALandingState, ScaffoldState>() {

    @Composable
    override fun Content(
        modifier: Modifier,
        arguments: InputArguments,
        state: FeatureALandingState,
        uiState: ScaffoldState,
        onAction: (Action) -> Unit
    ) {
        FeatureALandingScreenContent(
            featureDResult = arguments.getValue(FeatureALandingInputArguments()).orEmpty(),
            state = state,
            onActions = onAction,
            modifier = modifier
                .verticalScroll(rememberScrollState())
        )
    }

    @Composable
    override fun TopBar(
        modifier: Modifier,
        arguments: InputArguments,
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
