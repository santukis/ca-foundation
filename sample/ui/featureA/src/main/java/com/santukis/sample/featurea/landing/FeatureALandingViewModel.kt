package com.santukis.sample.featurea.landing

import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.CaViewModel

class FeatureALandingViewModel : CaViewModel<FeatureALandingState, FeatureALandingUiState>() {

    override fun initializeState(): FeatureALandingState = FeatureALandingState()

    @Composable
    override fun initializeUiState(): FeatureALandingUiState = featureALandingUiState()

    override fun handle(action: Action) {
        when (action) {
            is FeatureALandingAction.UpdateField01 -> updateState { state ->
                state.copy(field01 = action.value)
            }
            is FeatureALandingAction.UpdateField02 -> updateState { state ->
                state.copy(field02 = action.value)
            }
            is FeatureALandingAction.UpdateField03 -> updateState { state ->
                state.copy(field03 = action.value)
            }
            is FeatureALandingAction.UpdateField04 -> updateState { state ->
                state.copy(field04 = action.value)
            }
            is FeatureALandingAction.UpdateField05 -> updateState { state ->
                state.copy(field05 = action.value)
            }
            is FeatureALandingAction.UpdateField06 -> updateState { state ->
                state.copy(field06 = action.value)
            }
            is FeatureALandingAction.OpenNavigationDrawer -> executeOnUiState { uiState ->
                uiState.show()
            }
        }
    }
}
