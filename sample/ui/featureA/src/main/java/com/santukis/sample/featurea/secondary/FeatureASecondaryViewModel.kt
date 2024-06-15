package com.santukis.sample.featurea.secondary

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.CaViewModel
import com.santukis.ca.components.scaffold.ScreenAction
import com.santukis.ca.components.scaffold.StateHolder

class FeatureASecondaryViewModel : CaViewModel<FeatureASecondaryState>() {

    private val state: MutableState<FeatureASecondaryState> =
        mutableStateOf(FeatureASecondaryState())

    override fun getState(): State<FeatureASecondaryState> = state

    override fun handle(action: Action) {
        // no-op
    }
}
