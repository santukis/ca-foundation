package com.santukis.ca.components.scaffold.screenlayouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenState
import com.santukis.ca.components.scaffold.UiState
import com.santukis.navigation.InputArguments

abstract class BoxScreenLayout<
    S : ScreenState,
    US : UiState
    > : ScreenLayout<S, US>() {

    @Composable
    protected abstract fun BoxScope.Content(
        modifier: Modifier,
        arguments: InputArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    )

    @Composable
    override fun Layout(
        modifier: Modifier,
        arguments: InputArguments,
        state: S,
        uiState: US,
        onAction: (Action) -> Unit
    ) {
        Box(
            modifier = modifier,
            contentAlignment = contentAlignment(
                state = state,
                uiState = uiState
            ),
            propagateMinConstraints = propagateMinConstraints(
                state = state,
                uiState = uiState
            )
        ) {
            Content(
                modifier = Modifier
                    .contentModifier(
                        scope = this,
                        state = state,
                        uiState = uiState
                    ),
                arguments = arguments,
                state = state,
                uiState = uiState,
                onAction = onAction
            )
        }
    }

    protected open fun contentAlignment(
        state: S,
        uiState: US
    ): Alignment = Alignment.TopStart

    protected open fun propagateMinConstraints(
        state: S,
        uiState: US
    ): Boolean = false

    @Composable
    protected open fun Modifier.contentModifier(
        scope: BoxScope,
        state: S,
        uiState: US
    ) = this
}
