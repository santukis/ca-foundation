package com.santukis.scaffold.landing

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.UiState
import com.santukis.ca.components.scaffold.screenlayouts.BoxScreenLayout
import com.santukis.scaffold.landing.views.AppLandingScreenContent

class AppLandingScreenLayout : BoxScreenLayout<AppLandingState, UiState>() {

    @Composable
    override fun BoxScope.Content(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: AppLandingState,
        uiState: UiState,
        onAction: (Action) -> Unit
    ) {
        AppLandingScreenContent()
    }
}
