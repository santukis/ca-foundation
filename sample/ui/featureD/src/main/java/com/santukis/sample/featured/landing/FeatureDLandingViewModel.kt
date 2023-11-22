package com.santukis.sample.featured.landing

import androidx.lifecycle.ViewModel
import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.ScreenAction
import com.santukis.ca.components.scaffold.StateHolder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FeatureDLandingViewModel :
    ViewModel(),
    StateHolder<FeatureDLandingState>,
    ActionHandler {

    private var state: MutableStateFlow<FeatureDLandingState> = MutableStateFlow(FeatureDLandingState())

    override fun getState(): StateFlow<FeatureDLandingState> = state.asStateFlow()

    override fun handle(action: ScreenAction) {
        // no-op
    }
}
