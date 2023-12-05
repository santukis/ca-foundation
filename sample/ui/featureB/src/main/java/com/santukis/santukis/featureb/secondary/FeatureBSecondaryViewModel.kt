package com.santukis.santukis.featureb.secondary

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.ScreenAction
import com.santukis.ca.components.scaffold.StateHolder

class FeatureBSecondaryViewModel :
    ViewModel(),
    StateHolder<FeatureBSecondaryState>,
    ActionHandler {

    private val state: MutableState<FeatureBSecondaryState> =
        mutableStateOf(FeatureBSecondaryState())

    override fun getState(): State<FeatureBSecondaryState> = state

    override fun handle(action: ScreenAction) {
        // no-op
    }
}
