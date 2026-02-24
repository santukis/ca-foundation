package com.santukis.santukis.featureb.landing

import androidx.compose.runtime.Composable
import com.santukis.ca.ui.scaffold.Action
import com.santukis.ca.ui.scaffold.CaViewModel
import com.santukis.ca.ui.scaffold.states.ScaffoldState
import com.santukis.ca.ui.scaffold.states.scaffoldState

class FeatureBLandingViewModel :
    CaViewModel<FeatureBLandingState, ScaffoldState>() {

    override fun initializeState(): FeatureBLandingState = FeatureBLandingState()

    @Composable
    override fun initializeUiState(): ScaffoldState = scaffoldState()

    override fun handle(action: Action) {
        // no-op
    }
}
