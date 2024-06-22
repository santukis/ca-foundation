package com.santukis.ca.components.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santukis.navigation.InputArguments

abstract class ScreenBlock<S : ScreenState, US : UiState> {

    @Composable
    abstract fun Layout(
        modifier: Modifier,
        arguments: InputArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    )
}
