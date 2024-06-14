package com.santukis.sample.featurea.landing

import androidx.compose.material3.DrawerState
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.santukis.ca.components.scaffold.states.NavigationDrawerState
import com.santukis.ca.components.scaffold.states.ScaffoldState
import com.santukis.ca.components.scaffold.states.ScreenConfigurationState
import com.santukis.ca.components.scaffold.states.rememberNavigationDrawerUiState
import com.santukis.ca.components.scaffold.states.rememberScaffoldState

interface FeatureALandingUiState : NavigationDrawerState, ScaffoldState

@Composable
fun rememberFeatureALandingUiState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    drawerState: NavigationDrawerState = rememberNavigationDrawerUiState()
): FeatureALandingUiState =
    remember {
        DefaultFeatureALandingUiState(
            scaffoldState = scaffoldState,
            navigationDrawerState = drawerState
        )
    }


private class DefaultFeatureALandingUiState(
    private val scaffoldState: ScaffoldState,
    private val navigationDrawerState: NavigationDrawerState
): FeatureALandingUiState {

    override val drawerState: DrawerState =
        navigationDrawerState.drawerState

    override val snackbarHostState: SnackbarHostState =
        scaffoldState.snackbarHostState

    override val screenConfigurationState: ScreenConfigurationState =
        scaffoldState.screenConfigurationState

    override fun isVisible(): Boolean = navigationDrawerState.isVisible()

    override fun show(onShown: () -> Unit) {
        navigationDrawerState.show(onShown)
    }

    override fun hide(onHidden: () -> Unit) {
        navigationDrawerState.hide(onHidden)
    }
}
