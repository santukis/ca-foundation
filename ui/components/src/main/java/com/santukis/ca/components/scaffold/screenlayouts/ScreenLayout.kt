package com.santukis.ca.components.scaffold.screenlayouts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.ScreenState
import com.santukis.ca.components.scaffold.UiState

abstract class ScreenLayout<S : ScreenState, US : UiState> {

    @Composable
    abstract fun Layout(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    )
}
