package com.santukis.sample.featurea.secondary.states

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import com.santukis.ca.ui.scaffold.UiState
import com.santukis.ca.ui.scaffold.states.BottomSheetState
import com.santukis.ca.ui.scaffold.states.ScaffoldState
import com.santukis.ca.ui.scaffold.states.ScreenConfigurationState
import com.santukis.ca.ui.scaffold.states.bottomSheetState
import com.santukis.ca.ui.scaffold.states.scaffoldState
import com.santukis.ca.ui.scaffold.states.screenConfigurationState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun featureASecondaryScreenUiState(
    lazyListState: LazyListState = rememberLazyListState(),
    bottomSheetState: BottomSheetState = bottomSheetState()
): FeatureASecondaryScreenUiState {
    val scaffoldState = scaffoldState()
    val screenConfigurationState = screenConfigurationState()


    return FeatureASecondaryScreenUiState(
        lazyListState = lazyListState,
        bottomSheetState = bottomSheetState,
        scaffoldState = scaffoldState,
        screenConfigurationState = screenConfigurationState
    )
}

class FeatureASecondaryScreenUiState(
    val lazyListState: LazyListState,
    val bottomSheetState: BottomSheetState,
    scaffoldState: ScaffoldState,
    screenConfigurationState: ScreenConfigurationState
) : UiState,
    ScaffoldState by scaffoldState,
    ScreenConfigurationState by screenConfigurationState
