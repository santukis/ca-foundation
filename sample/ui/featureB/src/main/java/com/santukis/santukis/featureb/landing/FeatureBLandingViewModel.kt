package com.santukis.santukis.featureb.landing

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.CaViewModel

class FeatureBLandingViewModel :
    CaViewModel<FeatureBLandingState>() {

    private var state: MutableState<FeatureBLandingState> = mutableStateOf(FeatureBLandingState())

    override fun getState(): State<FeatureBLandingState> = state

    override fun handle(action: Action) {
        // no-op
    }
}
