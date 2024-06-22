package com.santukis.sample.featured.host

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.CaViewModel
import com.santukis.ca.components.scaffold.states.NavigationState
import com.santukis.ca.components.scaffold.states.navigationState
import com.santukis.sample.featured.FeatureDInnerNavigationGraph

class FeatureDHostViewModel :
    CaViewModel<FeatureDHostState, NavigationState>() {

    override fun initializeState(): FeatureDHostState = FeatureDHostState()

    @Composable
    override fun initializeUiState(): NavigationState = navigationState(
        navigationGraph = FeatureDInnerNavigationGraph()
    )

    override fun handle(action: Action) {
        // no-op
    }
}
