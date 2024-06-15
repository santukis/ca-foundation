package com.santukis.sample.featurec.landing

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.CaViewModel

class FeatureCLandingViewModel :
    CaViewModel<FeatureCLandingState>() {

    private var state: MutableState<FeatureCLandingState> = mutableStateOf(FeatureCLandingState())

    override fun getState(): State<FeatureCLandingState> = state

    override fun handle(action: Action) {
        // no-op
    }
}
