package com.santukis.scaffold.landing

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.ScreenAction
import com.santukis.ca.components.scaffold.StateHolder

class AppLandingViewModel :
    ViewModel(),
    StateHolder<AppLandingState>,
    ActionHandler {

    private var state: MutableState<AppLandingState> = mutableStateOf(AppLandingState())

    override fun getState(): State<AppLandingState> = state

    override fun handle(action: ScreenAction) {
        // no-op
    }
}
