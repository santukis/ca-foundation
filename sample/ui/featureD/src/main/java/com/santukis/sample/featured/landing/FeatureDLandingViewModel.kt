package com.santukis.sample.featured.landing

import androidx.lifecycle.ViewModel
import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.StateHolder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FeatureDLandingViewModel :
    ViewModel(),
    StateHolder<FeatureDLandingState>,
    ActionHandler<FeatureDLandingAction> {

    private var state: MutableStateFlow<FeatureDLandingState> = MutableStateFlow(FeatureDLandingState())

    override fun getState(): StateFlow<FeatureDLandingState> = state.asStateFlow()

    override fun handle(action: FeatureDLandingAction) {
        // no-op
    }
}
