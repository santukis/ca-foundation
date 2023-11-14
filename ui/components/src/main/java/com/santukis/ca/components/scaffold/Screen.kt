package com.santukis.ca.components.scaffold

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.window.core.layout.WindowSizeClass
import androidx.window.layout.WindowMetricsCalculator
import org.koin.compose.koinInject
import org.koin.core.component.getScopeName

@Stable
abstract class Screen<
    S : ScreenState,
    SA : ScreenAction,
    NA : NavigationAction
    > {

    @Composable
    protected open fun UiState(windowSizeClass: WindowSizeClass) {
        // no-op
    }

    @Composable
    protected abstract fun Content(
        arguments: ScreenArguments,
        state: S,
        onAction: (Action) -> Unit
    )

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
    fun Layout(
        modifier: Modifier = Modifier,
        arguments: ScreenArguments = NoArguments(),
        stateHolder: StateHolder<S> = koinInject(getScopeName()),
        actionHandler: ActionHandler<SA> = koinInject(getScopeName()),
        navigationHandler: (NA) -> Unit = {}
    ) {
        val state by stateHolder.getState().collectAsState()
        val onActions: (Action) -> Unit = remember {
            { action ->
                when (action) {
                    is NavigationAction -> (action as? NA)?.let(navigationHandler)
                    is ScreenAction -> (action as? SA)?.let { actionHandler.handle(action) }
                }
            }
        }

        UiState(computeWindowSizeClass(LocalContext.current))

        Scaffold(
            modifier = modifier,
            topBar = {
                TopBar(
                    arguments = arguments,
                    state = state,
                    onAction = onActions
                )
            },
            bottomBar = {
                BottomBar(
                    arguments = arguments,
                    state = state,
                    onAction = onActions
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
                    onAction = onActions
                )
            }
        }
    }

    private fun computeWindowSizeClass(context: Context): WindowSizeClass {
        val metrics = WindowMetricsCalculator
            .getOrCreate()
            .computeCurrentWindowMetrics(context)
        val width = metrics.bounds.width()
        val height = metrics.bounds.height()
        val density = context.resources.displayMetrics.density
        return WindowSizeClass.compute(width / density, height / density)
    }
}
