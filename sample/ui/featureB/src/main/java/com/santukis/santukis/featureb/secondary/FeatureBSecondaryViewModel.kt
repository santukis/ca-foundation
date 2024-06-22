package com.santukis.santukis.featureb.secondary

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.CaViewModel
import com.santukis.ca.components.scaffold.states.ScaffoldState
import com.santukis.ca.components.scaffold.states.scaffoldState

class FeatureBSecondaryViewModel :
    CaViewModel<FeatureBSecondaryState, ScaffoldState>() {

    override fun initializeState(): FeatureBSecondaryState = FeatureBSecondaryState()

    @Composable
    override fun initializeUiState(): ScaffoldState = scaffoldState()

    override fun handle(action: Action) {
        // no-op
    }
}
