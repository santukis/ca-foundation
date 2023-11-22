package com.santukis.sample.featurec.landing

import androidx.lifecycle.ViewModel
import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.ScreenAction
import com.santukis.ca.components.scaffold.StateHolder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FeatureCLandingViewModel :
    ViewModel(),
    StateHolder<FeatureCLandingState>,
    ActionHandler {

    private var state: MutableStateFlow<FeatureCLandingState> = MutableStateFlow(FeatureCLandingState())

    override fun getState(): StateFlow<FeatureCLandingState> = state.asStateFlow()

    override fun handle(action: ScreenAction) {
        // no-op
    }
}
