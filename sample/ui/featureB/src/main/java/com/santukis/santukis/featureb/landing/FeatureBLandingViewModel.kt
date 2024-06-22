package com.santukis.santukis.featureb.landing

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.CaViewModel
import com.santukis.ca.components.scaffold.states.ScaffoldState
import com.santukis.ca.components.scaffold.states.scaffoldState

class FeatureBLandingViewModel :
    CaViewModel<FeatureBLandingState, ScaffoldState>() {

    override fun initializeState(): FeatureBLandingState = FeatureBLandingState()

    @Composable
    override fun initializeUiState(): ScaffoldState = scaffoldState()

    override fun handle(action: Action) {
        // no-op
    }
}
