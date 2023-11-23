package com.santukis.santukis.featureb.secondary

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.screenlayouts.ScaffoldScreenLayout
import com.santukis.santukis.featureb.secondary.views.FeatureBSecondaryScreenContent

class FeatureBSecondaryScreenLayout : ScaffoldScreenLayout<FeatureBSecondaryState>() {

    @Composable
    override fun BoxScope.Content(
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
