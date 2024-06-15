package com.santukis.sample.featurea.landing

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.CaViewModel

class FeatureALandingViewModel : CaViewModel<FeatureALandingState>() {

    private var state: MutableState<FeatureALandingState> = mutableStateOf(FeatureALandingState())

    override fun getState(): State<FeatureALandingState> = state

    override fun handle(action: Action) {
        when (action) {
            is FeatureALandingAction.UpdateField01 ->
                state.value = state.value.copy(field01 = action.value)
            is FeatureALandingAction.UpdateField02 ->
                state.value = state.value.copy(field02 = action.value)
            is FeatureALandingAction.UpdateField03 ->
                state.value = state.value.copy(field03 = action.value)
            is FeatureALandingAction.UpdateField04 ->
                state.value = state.value.copy(field04 = action.value)
            is FeatureALandingAction.UpdateField05 ->
                state.value = state.value.copy(field05 = action.value)
            is FeatureALandingAction.UpdateField06 ->
                state.value = state.value.copy(field06 = action.value)
        }
    }
}
