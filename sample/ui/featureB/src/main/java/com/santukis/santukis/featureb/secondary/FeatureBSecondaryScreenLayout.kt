package com.santukis.santukis.featureb.secondary

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScaffoldScreenLayout
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.santukis.featureb.secondary.views.FeatureBSecondaryScreenContent

class FeatureBSecondaryScreenLayout : ScaffoldScreenLayout<FeatureBSecondaryState>() {

    @Composable
    override fun Content(
        arguments: ScreenArguments,
        state: FeatureBSecondaryState,
        onAction: (Action) -> Unit
    ) {
        FeatureBSecondaryScreenContent(
            state = state,
            onAction = onAction
        )
    }
}
