package com.santukis.sample.featurea.secondary.states

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.santukis.ca.components.scaffold.UiState
import com.santukis.ca.components.scaffold.states.BottomSheetState
import com.santukis.ca.components.scaffold.states.ScaffoldState
import com.santukis.ca.components.scaffold.states.ScreenConfigurationState
import com.santukis.ca.components.scaffold.states.bottomSheetState
import com.santukis.ca.components.scaffold.states.scaffoldState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun featureASecondaryScreenUiState(
    lazyListState: LazyListState = rememberLazyListState(),
    bottomSheetState: BottomSheetState = bottomSheetState()
): FeatureASecondaryScreenUiState {
    val scaffoldState = scaffoldState()

    return FeatureASecondaryScreenUiState(
        lazyListState = lazyListState,
        bottomSheetState = bottomSheetState,
        snackbarHostState = scaffoldState.snackbarHostState,
        screenConfigurationState = scaffoldState.screenConfigurationState
    )
}

class FeatureASecondaryScreenUiState(
    val lazyListState: LazyListState,
    val bottomSheetState: BottomSheetState,
    override val snackbarHostState: SnackbarHostState,
    override val screenConfigurationState: ScreenConfigurationState
) : UiState, ScaffoldState
