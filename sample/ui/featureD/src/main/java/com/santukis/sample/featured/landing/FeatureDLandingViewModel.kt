package com.santukis.sample.featured.landing

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.CaViewModel

class FeatureDLandingViewModel :
    CaViewModel<FeatureDLandingState>() {

    private var state: MutableState<FeatureDLandingState> = mutableStateOf(FeatureDLandingState())

    override fun getState(): State<FeatureDLandingState> = state

    override fun handle(action: Action) {
        // no-op
    }
}
