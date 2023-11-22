package com.santukis.sample.featurea.landing

import androidx.lifecycle.ViewModel
import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.ScreenAction
import com.santukis.ca.components.scaffold.StateHolder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FeatureALandingViewModel :
    ViewModel(),
    StateHolder<FeatureALandingState>,
    ActionHandler {

    private var state: MutableStateFlow<FeatureALandingState> = MutableStateFlow(FeatureALandingState())

    override fun getState(): StateFlow<FeatureALandingState> = state.asStateFlow()

    override fun handle(action: ScreenAction) {
        // no-op
    }
}
