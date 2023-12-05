package com.santukis.santukis.featureb.landing

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.ScreenAction
import com.santukis.ca.components.scaffold.StateHolder

class FeatureBLandingViewModel :
    ViewModel(),
    StateHolder<FeatureBLandingState>,
    ActionHandler {

    private var state: MutableState<FeatureBLandingState> = mutableStateOf(FeatureBLandingState())

    override fun getState(): State<FeatureBLandingState> = state

    override fun handle(action: ScreenAction) {
        // no-op
    }
}
