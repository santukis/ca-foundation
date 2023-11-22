package com.santukis.sample.featurea.secondary

import androidx.lifecycle.ViewModel
import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.ScreenAction
import com.santukis.ca.components.scaffold.StateHolder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FeatureASecondaryViewModel :
    ViewModel(),
    StateHolder<FeatureASecondaryState>,
    ActionHandler {

    private val state: MutableStateFlow<FeatureASecondaryState> =
        MutableStateFlow(FeatureASecondaryState())

    override fun getState(): StateFlow<FeatureASecondaryState> = state.asStateFlow()

    override fun handle(action: ScreenAction) {
        // no-op
    }
}
