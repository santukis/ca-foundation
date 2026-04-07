package com.santukis.sample.featurea.landing

import androidx.compose.runtime.Composable
import com.santukis.ca.ui.scaffold.states.NavigationDrawerState
import com.santukis.ca.ui.scaffold.states.ScaffoldState
import com.santukis.ca.ui.scaffold.states.ScreenConfigurationState
import com.santukis.ca.ui.scaffold.states.navigationDrawerUiState
import com.santukis.ca.ui.scaffold.states.scaffoldState
import com.santukis.ca.ui.scaffold.states.screenConfigurationState

interface FeatureALandingUiState :
    NavigationDrawerState,
    ScaffoldState,
    ScreenConfigurationState

@Composable
fun featureALandingUiState(
    drawerState: NavigationDrawerState = navigationDrawerUiState()
): FeatureALandingUiState {
    val scaffoldState: ScaffoldState = scaffoldState()
    val screenConfigurationState: ScreenConfigurationState = screenConfigurationState()

    return DefaultFeatureALandingUiState(
        scaffoldState = scaffoldState,
        navigationDrawerState = drawerState,
        screenConfigurationState = screenConfigurationState
    )
}


private class DefaultFeatureALandingUiState(
    scaffoldState: ScaffoldState,
    navigationDrawerState: NavigationDrawerState,
    screenConfigurationState: ScreenConfigurationState
) : FeatureALandingUiState,
    ScaffoldState by scaffoldState,
    NavigationDrawerState by navigationDrawerState,
    ScreenConfigurationState by screenConfigurationState
