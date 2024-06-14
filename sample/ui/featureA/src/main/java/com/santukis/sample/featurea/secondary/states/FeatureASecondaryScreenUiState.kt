package com.santukis.sample.featurea.secondary.states

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.santukis.ca.components.scaffold.UiState
import com.santukis.ca.components.scaffold.states.BottomSheetState
import com.santukis.ca.components.scaffold.states.ScaffoldState
import com.santukis.ca.components.scaffold.states.ScreenConfigurationState
import com.santukis.ca.components.scaffold.states.rememberBottomSheetState
import com.santukis.ca.components.scaffold.states.rememberScaffoldState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberFeatureASecondaryScreenUiState(
    lazyListState: LazyListState = rememberLazyListState(),
    bottomSheetState: BottomSheetState = rememberBottomSheetState()
): FeatureASecondaryScreenUiState {
    val scaffoldState = rememberScaffoldState()

    return remember {
        FeatureASecondaryScreenUiState(
            lazyListState = lazyListState,
            bottomSheetState = bottomSheetState,
            snackbarHostState = scaffoldState.snackbarHostState,
            screenConfigurationState = scaffoldState.screenConfigurationState
        )
    }
}

class FeatureASecondaryScreenUiState(
    val lazyListState: LazyListState,
    val bottomSheetState: BottomSheetState,
    override val snackbarHostState: SnackbarHostState,
    override val screenConfigurationState: ScreenConfigurationState
) : UiState, ScaffoldState
