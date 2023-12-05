package com.santukis.scaffold.landing

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.screenlayouts.BoxScreenLayout
import com.santukis.scaffold.landing.views.AppLandingScreenContent

class AppLandingScreenLayout : BoxScreenLayout<AppLandingState>() {

    @Composable
    override fun BoxScope.Content(
        arguments: ScreenArguments,
        state: AppLandingState,
        onAction: (Action) -> Unit
    ) {
        AppLandingScreenContent()
    }
}
