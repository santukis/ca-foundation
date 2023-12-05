package com.santukis.sample.featured.landing

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.ScreenAction
import com.santukis.ca.components.scaffold.StateHolder

class FeatureDLandingViewModel :
    ViewModel(),
    StateHolder<FeatureDLandingState>,
    ActionHandler {

    private var state: MutableState<FeatureDLandingState> = mutableStateOf(FeatureDLandingState())

    override fun getState(): State<FeatureDLandingState> = state

    override fun handle(action: ScreenAction) {
        // no-op
    }
}
