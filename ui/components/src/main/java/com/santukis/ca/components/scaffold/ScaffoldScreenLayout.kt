package com.santukis.ca.components.scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

open class ScaffoldScreenLayout<S : ScreenState> : ScreenLayout<S>() {

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
