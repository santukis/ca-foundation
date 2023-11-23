package com.santukis.ca.components.scaffold.screenlayouts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.ScreenState

abstract class ScreenLayout<S : ScreenState> {

    @Composable
    protected open fun UiState(
        arguments: ScreenArguments,
        state: S,
    ) {
        // no-op
    }

    @Composable
    abstract fun Layout(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: S,
        onAction: (Action) -> Unit
    )
}
