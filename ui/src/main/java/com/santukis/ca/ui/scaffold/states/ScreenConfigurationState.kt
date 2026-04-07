package com.santukis.ca.ui.scaffold.states

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.platform.LocalConfiguration

/**
 * Represents the configuration state of the screen, including window size and orientation.
 */
interface ScreenConfigurationState {

    /**
     * The state of the window size class, which helps in creating adaptive layouts.
     */
    val windowSizeClassState: WindowSizeClassState

    /**
     * Checks if the device is in portrait orientation.
     *
     * @return `true` if in portrait, `false` otherwise.
     */
    fun isPortrait(): Boolean

    /**
     * Checks if the device is in landscape orientation.
     *
     * @return `true` if in landscape, `false` otherwise.
     */
    fun isLandscape(): Boolean
}

/**
 * Creates and remembers a [ScreenConfigurationState].
 *
 * This function uses [LocalConfiguration] to get the current device configuration.
 *
 * @param windowSizeClassState The [WindowSizeClassState] to be used. Defaults to a new state.
 * @return A remembered instance of [ScreenConfigurationState].
 */
@Composable
fun screenConfigurationState(
    windowSizeClassState: WindowSizeClassState = windowSizeClassState(),
): ScreenConfigurationState {
    val configuration = LocalConfiguration.current

    return DefaultScreenConfigurationState(
        windowSizeClassState = windowSizeClassState,
        configuration = configuration
    )
}

/**
 * The default, immutable implementation of [ScreenConfigurationState].
 *
 * @param windowSizeClassState The window size class state.
 * @param configuration The Android [Configuration] object.
 */
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
