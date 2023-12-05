package com.santukis.sample.featurec.landing

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.ScreenAction
import com.santukis.ca.components.scaffold.StateHolder

class FeatureCLandingViewModel :
    ViewModel(),
    StateHolder<FeatureCLandingState>,
    ActionHandler {

    private var state: MutableState<FeatureCLandingState> = mutableStateOf(FeatureCLandingState())

    override fun getState(): State<FeatureCLandingState> = state

    override fun handle(action: ScreenAction) {
        // no-op
    }
}
