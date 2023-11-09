package com.santukis.sample.featurea.secondary

import androidx.compose.runtime.Composable
import androidx.window.core.layout.WindowSizeClass
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.sample.featurea.secondary.states.FeatureASecondaryScreenUiState
import com.santukis.sample.featurea.secondary.states.rememberFeatureASecondaryScreenUiState
import com.santukis.sample.featurea.secondary.views.FeatureASecondaryScreenContent
import com.santukis.sample.featurea.secondary.views.FeatureASecondaryScreenTopBar

class FeatureASecondaryScreen : Screen<
    FeatureASecondaryState,
    FeatureASecondaryAction,
    FeatureASecondaryNavigationAction<*>
    >() {

    private lateinit var uiState: FeatureASecondaryScreenUiState

    @Composable
    override fun UiState(windowSizeClass: WindowSizeClass) {
        uiState = rememberFeatureASecondaryScreenUiState(
            windowSizeClass = windowSizeClass
        )
    }

    @Composable
    override fun TopBar(
        arguments: ScreenArguments,
        state: FeatureASecondaryState,
        onAction: (Action) -> Unit
    ) {
        if (uiState.isWindowWidthCompat()) {
            FeatureASecondaryScreenTopBar(
                screenState = state,
                uiState = uiState,
                onAction = onAction
            )
        }
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
