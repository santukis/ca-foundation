package com.santukis.ca.components.scaffold.screenlayouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.ScreenState

abstract class ScaffoldScreenLayout<S : ScreenState> : ScreenLayout<S>() {

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

        Scaffold(
            modifier = modifier,
            topBar = {
                TopBar(
                    arguments = arguments,
                    state = state,
                    onAction = onAction
                )
            },
            bottomBar = {
                BottomBar(
                    arguments = arguments,
                    state = state,
                    onAction = onAction
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Content(
                    arguments = arguments,
                    state = state,
                    onAction = onAction
                )
            }
        }
    }
}
