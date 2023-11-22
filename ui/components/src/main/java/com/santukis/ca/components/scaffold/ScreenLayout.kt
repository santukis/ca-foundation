package com.santukis.ca.components.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

abstract class ScreenLayout<S : ScreenState> {

    @Composable
    protected open fun UiState(
        arguments: ScreenArguments,
        state: S,
    ) {
        // no-op
    }

    @Composable
    protected open fun TopBar(
        arguments: ScreenArguments,
        state: S,
        onAction: (Action) -> Unit
    ) {
        // no-op
    }

    @Composable
    protected open fun BottomBar(
        arguments: ScreenArguments,
        state: S,
        onAction: (Action) -> Unit
    ) {
        // no-op
    }

    @Composable
    protected open fun Content(
        arguments: ScreenArguments,
        state: S,
        onAction: (Action) -> Unit
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
