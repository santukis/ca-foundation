package com.santukis.santukis.featureb.secondary

import androidx.lifecycle.ViewModel
import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.ScreenAction
import com.santukis.ca.components.scaffold.StateHolder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FeatureBSecondaryViewModel :
    ViewModel(),
    StateHolder<FeatureBSecondaryState>,
    ActionHandler {

    private val state: MutableStateFlow<FeatureBSecondaryState> =
        MutableStateFlow(FeatureBSecondaryState())

    override fun getState(): StateFlow<FeatureBSecondaryState> = state.asStateFlow()

    override fun handle(action: ScreenAction) {
        // no-op
    }
}
