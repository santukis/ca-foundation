package com.santukis.scaffold.landing

import androidx.compose.runtime.Composable
import com.santukis.ca.ui.scaffold.Action
import com.santukis.ca.ui.scaffold.CaViewModel
import com.santukis.ca.ui.scaffold.states.NavigationState
import com.santukis.ca.ui.scaffold.states.navigationState

class AppLandingViewModel : CaViewModel<AppLandingState, NavigationState>() {

    override fun initializeState(): AppLandingState = AppLandingState()

    @Composable
    override fun initializeUiState(): NavigationState = navigationState()

    override fun handle(action: Action) {
        // no-op
    }
}
