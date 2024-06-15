package com.santukis.scaffold.landing

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.CaViewModel

class AppLandingViewModel : CaViewModel<AppLandingState>() {

    private var state: MutableState<AppLandingState> = mutableStateOf(AppLandingState())

    override fun getState(): State<AppLandingState> = state

    override fun handle(action: Action) {
        // no-op
    }
}
