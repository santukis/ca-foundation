package com.santukis.sample.featurea.secondary

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.Action
import com.santukis.navigation.InputArguments
import com.santukis.ca.components.scaffold.screenlayouts.ScaffoldScreenLayout
import com.santukis.sample.featurea.secondary.states.FeatureASecondaryScreenUiState
import com.santukis.sample.featurea.secondary.views.FeatureASecondaryScreenContent

class FeatureASecondaryLandscapeScreenLayout : ScaffoldScreenLayout<
        FeatureASecondaryState, FeatureASecondaryScreenUiState>() {

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
            onAction = onAction
        )
    }
}
