package com.santukis.ca.components.scaffold.states

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun rememberScreenConfigurationState(
    windowSizeClassState: WindowSizeClassState = rememberWindowSizeClassState(),
): ScreenConfigurationState {
    val configuration = LocalConfiguration.current

    return remember(
        windowSizeClassState
    ) {
        ScreenConfigurationState(
            windowSizeClassState = windowSizeClassState,
            configuration = configuration
        )
    }
}

@Immutable
class ScreenConfigurationState(
    val windowSizeClassState: WindowSizeClassState,
    val configuration: Configuration
) {

    fun isPortrait(): Boolean =
        configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    fun isLandscape(): Boolean =
        configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
}
