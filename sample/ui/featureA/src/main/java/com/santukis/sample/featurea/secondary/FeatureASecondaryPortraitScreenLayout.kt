package com.santukis.sample.featurea.secondary

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santukis.ca.ui.navigation.InputArguments
import com.santukis.ca.ui.scaffold.Action
import com.santukis.ca.ui.scaffold.screenlayouts.ScaffoldScreenLayout
import com.santukis.sample.featurea.secondary.states.FeatureASecondaryScreenUiState
import com.santukis.sample.featurea.secondary.views.FeatureASecondaryScreenContent
import com.santukis.sample.featurea.secondary.views.FeatureASecondaryScreenTopBar

class FeatureASecondaryPortraitScreenLayout : ScaffoldScreenLayout<
        FeatureASecondaryState, FeatureASecondaryScreenUiState>() {

    @Composable
    override fun TopBar(
        modifier: Modifier,
        arguments: InputArguments,
        state: FeatureASecondaryState,
        uiState: FeatureASecondaryScreenUiState,
        onAction: (Action) -> Unit
    ) {
        FeatureASecondaryScreenTopBar(
            screenState = state,
            uiState = uiState,
            onAction = onAction
        )
    }

    @Composable
    override fun Content(
        modifier: Modifier,
        arguments: InputArguments,
        state: FeatureASecondaryState,
        uiState: FeatureASecondaryScreenUiState,
        onAction: (Action) -> Unit
    ) {
        FeatureASecondaryScreenContent(
            screenState = state,
            uiState = uiState,
            onAction = onAction,
            modifier = modifier
        )
    }
}
