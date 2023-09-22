package com.santukis.scaffold.landing

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.scaffold.landing.views.AppLandingScreenContent

class AppLandingScreen : Screen<
    AppLandingState,
    AppLandingAction,
    AppLandingNavigationAction
    >() {

    @Composable
    override fun Content(
        arguments: ScreenArguments,
        state: AppLandingState,
        onAction: (Action) -> Unit
    ) {
        AppLandingScreenContent()
    }
}
