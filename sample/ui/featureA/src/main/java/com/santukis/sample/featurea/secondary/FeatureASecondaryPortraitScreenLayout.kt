package com.santukis.sample.featurea.secondary

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.screenlayouts.ScaffoldScreenLayout
import com.santukis.sample.featurea.secondary.states.FeatureASecondaryScreenUiState
import com.santukis.sample.featurea.secondary.states.rememberFeatureASecondaryScreenUiState
import com.santukis.sample.featurea.secondary.views.FeatureASecondaryScreenContent
import com.santukis.sample.featurea.secondary.views.FeatureASecondaryScreenTopBar

class FeatureASecondaryPortraitScreenLayout : ScaffoldScreenLayout<FeatureASecondaryState>() {

    private lateinit var uiState: FeatureASecondaryScreenUiState

    @Composable
    override fun UiState(
        arguments: ScreenArguments,
        state: FeatureASecondaryState
    ) {
        uiState = rememberFeatureASecondaryScreenUiState()
    }

    @Composable
    override fun TopBar(
        arguments: ScreenArguments,
        state: FeatureASecondaryState,
        onAction: (Action) -> Unit
    ) {
        FeatureASecondaryScreenTopBar(
            screenState = state,
            uiState = uiState,
            onAction = onAction
        )
    }

    @Composable
    override fun BoxScope.Content(
        arguments: ScreenArguments,
        state: FeatureASecondaryState,
        onAction: (Action) -> Unit
    ) {
        FeatureASecondaryScreenContent(
            screenState = state,
            uiState = uiState,
            onAction = onAction
        )
    }
}
