package com.santukis.sample.featurea.secondary

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.CaViewModel
import com.santukis.sample.featurea.secondary.states.FeatureASecondaryScreenUiState
import com.santukis.sample.featurea.secondary.states.featureASecondaryScreenUiState

class FeatureASecondaryViewModel :
    CaViewModel<FeatureASecondaryState, FeatureASecondaryScreenUiState>() {

    override fun initializeState(): FeatureASecondaryState = FeatureASecondaryState()

    @Composable
    override fun initializeUiState(): FeatureASecondaryScreenUiState =
        featureASecondaryScreenUiState()

    override fun handle(action: Action) {
        // no-op
    }
}
