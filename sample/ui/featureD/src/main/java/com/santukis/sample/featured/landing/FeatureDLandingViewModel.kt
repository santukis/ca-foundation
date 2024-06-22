package com.santukis.sample.featured.landing

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.CaViewModel
import com.santukis.ca.components.scaffold.states.ScaffoldState
import com.santukis.ca.components.scaffold.states.scaffoldState

class FeatureDLandingViewModel :
    CaViewModel<FeatureDLandingState, ScaffoldState>() {

    override fun initializeState(): FeatureDLandingState = FeatureDLandingState()

    @Composable
    override fun initializeUiState(): ScaffoldState = scaffoldState()

    override fun handle(action: Action) {
        // no-op
    }
}
