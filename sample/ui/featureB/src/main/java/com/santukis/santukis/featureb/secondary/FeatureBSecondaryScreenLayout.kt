package com.santukis.santukis.featureb.secondary

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.screenlayouts.ScaffoldScreenLayout
import com.santukis.ca.components.scaffold.states.ScaffoldState
import com.santukis.santukis.featureb.secondary.views.FeatureBSecondaryScreenContent

class FeatureBSecondaryScreenLayout : ScaffoldScreenLayout<FeatureBSecondaryState, ScaffoldState>() {

    @Composable
    override fun Content(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: FeatureBSecondaryState,
        uiState: ScaffoldState,
        onAction: (Action) -> Unit
    ) {
        FeatureBSecondaryScreenContent(
            state = state,
            onAction = onAction
        )
    }
}
