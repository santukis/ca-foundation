package com.santukis.sample.featurea.secondary

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.sample.featurea.secondary.views.FeatureASecondaryScreenContent

class FeatureASecondaryScreen : Screen<
    FeatureASecondaryState,
    FeatureASecondaryAction,
    FeatureASecondaryNavigationAction<*>
    >() {

    @Composable
    override fun Content(
        arguments: ScreenArguments,
        state: FeatureASecondaryState,
        onAction: (Action) -> Unit
    ) {
        FeatureASecondaryScreenContent(
            state = state,
            onAction = onAction
        )
    }
}
