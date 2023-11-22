package com.santukis.ca.components.scaffold

import androidx.compose.runtime.Composable

abstract class ScreenBlock<S : ScreenState> {

    @Composable
    abstract fun Layout(
        arguments: ScreenArguments,
        state: S,
        onAction: (Action) -> Unit
    )
}
