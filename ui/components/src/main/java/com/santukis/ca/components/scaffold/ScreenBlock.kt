package com.santukis.ca.components.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

abstract class ScreenBlock<S : ScreenState, US : UiState> {

    @Composable
    abstract fun Layout(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    )
}
