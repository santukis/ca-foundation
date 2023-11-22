package com.santukis.scaffold.landing

import androidx.lifecycle.ViewModel
import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.ScreenAction
import com.santukis.ca.components.scaffold.StateHolder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppLandingViewModel :
    ViewModel(),
    StateHolder<AppLandingState>,
    ActionHandler {

    private var state: MutableStateFlow<AppLandingState> = MutableStateFlow(AppLandingState())

    override fun getState(): StateFlow<AppLandingState> = state.asStateFlow()

    override fun handle(action: ScreenAction) {
        // no-op
    }
}
