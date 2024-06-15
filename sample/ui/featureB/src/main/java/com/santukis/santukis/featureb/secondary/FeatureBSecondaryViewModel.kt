package com.santukis.santukis.featureb.secondary

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.CaViewModel

class FeatureBSecondaryViewModel :
    CaViewModel<FeatureBSecondaryState>() {

    private val state: MutableState<FeatureBSecondaryState> =
        mutableStateOf(FeatureBSecondaryState())

    override fun getState(): State<FeatureBSecondaryState> = state

    override fun handle(action: Action) {
        // no-op
    }
}
