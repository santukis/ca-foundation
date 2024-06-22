package com.santukis.sample.featurec.landing

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.CaViewModel
import com.santukis.ca.components.scaffold.states.ScaffoldState
import com.santukis.ca.components.scaffold.states.scaffoldState

class FeatureCLandingViewModel :
    CaViewModel<FeatureCLandingState, ScaffoldState>() {

    override fun initializeState(): FeatureCLandingState = FeatureCLandingState()

    @Composable
    override fun initializeUiState(): ScaffoldState = scaffoldState()

    override fun handle(action: Action) {
        // no-op
    }
}
