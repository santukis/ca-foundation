package com.santukis.ca.components.scaffold.states

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember

@Composable
fun rememberScreenConfigurationState(
    windowSizeClassState: WindowSizeClassState = rememberWindowSizeClassState()
): ScreenConfigurationState =
    remember(
        windowSizeClassState
    ) {
        ScreenConfigurationState(
            windowSizeClassState = windowSizeClassState
        )
    }

@Immutable
class ScreenConfigurationState(
    val windowSizeClassState: WindowSizeClassState
) {

    fun isPortrait(): Boolean =
        windowSizeClassState.getHeightSize() > windowSizeClassState.getWidthSize()

    fun isLandscape(): Boolean =
        windowSizeClassState.getWidthSize() > windowSizeClassState.getHeightSize()
}
