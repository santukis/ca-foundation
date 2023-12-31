package com.santukis.sample.featurea.secondary

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.ScreenAction
import com.santukis.ca.components.scaffold.StateHolder

class FeatureASecondaryViewModel :
    ViewModel(),
    StateHolder<FeatureASecondaryState>,
    ActionHandler {

    private val state: MutableState<FeatureASecondaryState> =
        mutableStateOf(FeatureASecondaryState())

    override fun getState(): State<FeatureASecondaryState> = state

    override fun handle(action: ScreenAction) {
        // no-op
    }
}
