package com.santukis.santukis.featureb.landing

import androidx.lifecycle.ViewModel
import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.StateHolder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FeatureBLandingViewModel :
    ViewModel(),
    StateHolder<FeatureBLandingState>,
    ActionHandler<FeatureBLandingAction> {

    private var state: MutableStateFlow<FeatureBLandingState> = MutableStateFlow(FeatureBLandingState())

    override fun getState(): StateFlow<FeatureBLandingState> = state.asStateFlow()

    override fun handle(action: FeatureBLandingAction) {
        // no-op
    }
}
