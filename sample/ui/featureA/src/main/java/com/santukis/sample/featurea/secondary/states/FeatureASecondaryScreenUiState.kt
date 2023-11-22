package com.santukis.sample.featurea.secondary.states

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.window.core.layout.WindowSizeClass
import com.santukis.ca.components.scaffold.UiState
import com.santukis.ca.components.scaffold.states.BottomSheetState
import com.santukis.ca.components.scaffold.states.rememberBottomSheetState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberFeatureASecondaryScreenUiState(
    lazyListState: LazyListState = rememberLazyListState(),
    bottomSheetState: BottomSheetState = rememberBottomSheetState()
): FeatureASecondaryScreenUiState =
    remember {
        FeatureASecondaryScreenUiState(
            lazyListState = lazyListState,
            bottomSheetState = bottomSheetState
        )
    }

class FeatureASecondaryScreenUiState(
    val lazyListState: LazyListState,
    val bottomSheetState: BottomSheetState
) : UiState()
