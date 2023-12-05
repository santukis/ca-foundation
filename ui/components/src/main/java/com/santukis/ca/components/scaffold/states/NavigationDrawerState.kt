package com.santukis.ca.components.scaffold.states

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun rememberNavigationDrawerState(
    initialValue: DrawerValue = DrawerValue.Closed
): NavigationDrawerState {
    val drawerState = rememberDrawerState(initialValue = initialValue)
    val coroutineScope = rememberCoroutineScope()

    return remember {
        NavigationDrawerState(
            drawerState = drawerState,
            coroutineScope = coroutineScope
        )
    }
}

class NavigationDrawerState(
    val drawerState: DrawerState,
    private val coroutineScope: CoroutineScope
) {

    fun openDrawer() {
        coroutineScope.launch {
            drawerState.open()
        }
    }

    fun closeDrawer() {
        coroutineScope.launch {
            drawerState.close()
        }
    }
}
