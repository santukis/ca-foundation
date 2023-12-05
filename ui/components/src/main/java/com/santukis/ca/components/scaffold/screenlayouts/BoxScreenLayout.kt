package com.santukis.ca.components.scaffold.screenlayouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.ScreenState

abstract class BoxScreenLayout<S : ScreenState> : ScreenLayout<S>() {

    @Composable
    protected abstract fun BoxScope.Content(
        arguments: ScreenArguments,
        state: S,
        onAction: (Action) -> Unit
    )

    @Composable
    override fun Layout(
        modifier: Modifier,
        arguments: ScreenArguments,
        state: S,
        onAction: (Action) -> Unit
    ) {
        UiState(
            arguments = arguments,
            state = state
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Content(
                arguments = arguments,
                state = state,
                onAction = onAction
            )
        }
    }
}
