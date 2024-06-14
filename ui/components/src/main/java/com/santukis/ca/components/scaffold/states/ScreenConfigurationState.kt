package com.santukis.ca.components.scaffold.states

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration

interface ScreenConfigurationState {

    val windowSizeClassState: WindowSizeClassState

    fun isPortrait(): Boolean

    fun isLandscape(): Boolean
}


@Composable
fun rememberScreenConfigurationState(
    windowSizeClassState: WindowSizeClassState = rememberWindowSizeClassState(),
): ScreenConfigurationState {
    val configuration = LocalConfiguration.current

    return remember(
        windowSizeClassState
    ) {
        DefaultScreenConfigurationState(
            windowSizeClassState = windowSizeClassState,
            configuration = configuration
        )
    }
}

@Immutable
internal class DefaultScreenConfigurationState(
    override val windowSizeClassState: WindowSizeClassState,
    private val configuration: Configuration
) : ScreenConfigurationState {

    override fun isPortrait(): Boolean =
        configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    override fun isLandscape(): Boolean =
        configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
}
