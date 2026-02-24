package com.santukis.ca.ui.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santukis.ca.ui.navigation.InputArguments

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
