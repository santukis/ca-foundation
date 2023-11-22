package com.santukis.sample.featurea.secondary

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScaffoldScreenLayout
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.sample.featurea.secondary.states.FeatureASecondaryScreenUiState
import com.santukis.sample.featurea.secondary.states.rememberFeatureASecondaryScreenUiState
import com.santukis.sample.featurea.secondary.views.FeatureASecondaryScreenContent

class FeatureASecondaryLandscapeScreenLayout : ScaffoldScreenLayout<FeatureASecondaryState>() {

    private lateinit var uiState: FeatureASecondaryScreenUiState

    @Composable
    override fun UiState(
        arguments: ScreenArguments,
        state: FeatureASecondaryState
    ) {
        uiState = rememberFeatureASecondaryScreenUiState()
    }

    @Composable
    override fun Content(
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
