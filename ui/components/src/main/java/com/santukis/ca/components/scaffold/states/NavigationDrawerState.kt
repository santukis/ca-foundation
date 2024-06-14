package com.santukis.ca.components.scaffold.states

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.santukis.ca.components.scaffold.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

interface NavigationDrawerState : UiState, VisibilityState {
    val drawerState: DrawerState
}

@Composable
fun rememberNavigationDrawerUiState(
    initialValue: DrawerValue = DrawerValue.Closed
): NavigationDrawerState {
    val screenConfigurationState = rememberScreenConfigurationState()
    val drawerState = rememberDrawerState(initialValue = initialValue)
    val coroutineScope = rememberCoroutineScope()

    return remember {
        DefaultNavigationDrawerState(
            drawerState = drawerState,
            screenConfigurationState = screenConfigurationState,
            coroutineScope = coroutineScope
        )
    }
}

internal class DefaultNavigationDrawerState(
    override val drawerState: DrawerState,
    override val screenConfigurationState: ScreenConfigurationState,
    private val coroutineScope: CoroutineScope
): NavigationDrawerState {

    override fun isVisible(): Boolean = drawerState.isOpen

    override fun show(onShown: () -> Unit) {
        coroutineScope.launch {
            drawerState.open()
        }.invokeOnCompletion {
            onShown()
        }
    }

    override fun hide(onHidden: () -> Unit) {
        coroutineScope.launch {
            drawerState.close()
        }.invokeOnCompletion {
            onHidden()
        }
    }
}
