package com.santukis.sample.featured.landing

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.Action
import com.santukis.navigation.InputArguments
import com.santukis.ca.components.scaffold.screenlayouts.ScaffoldScreenLayout
import com.santukis.ca.components.scaffold.states.ScaffoldState
import com.santukis.sample.featured.landing.navigation.FeatureDLandingInputArguments
import com.santukis.sample.featured.landing.views.FeatureDLandingScreenContent

class FeatureDLandingScreenLayout : ScaffoldScreenLayout<FeatureDLandingState, ScaffoldState>() {

    @Composable
    override fun Content(
        modifier: Modifier,
        arguments: InputArguments,
        state: FeatureDLandingState,
        uiState: ScaffoldState,
        onAction: (Action) -> Unit
    ) {
        FeatureDLandingScreenContent(
            anyParam = arguments.getValue(FeatureDLandingInputArguments()).orEmpty(),
            state = state,
            onActions = onAction
        )
    }
}
