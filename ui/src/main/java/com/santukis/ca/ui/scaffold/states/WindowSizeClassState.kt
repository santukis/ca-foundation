package com.santukis.ca.ui.scaffold.states

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowSizeClass.Companion.HEIGHT_DP_EXPANDED_LOWER_BOUND
import androidx.window.core.layout.WindowSizeClass.Companion.HEIGHT_DP_MEDIUM_LOWER_BOUND
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_EXPANDED_LOWER_BOUND
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_MEDIUM_LOWER_BOUND
import androidx.window.layout.WindowMetricsCalculator

/**
 * Represents the window size class state, which categorizes the window into different size buckets.
 * This is useful for creating adaptive layouts that respond to different screen sizes.
 */
interface WindowSizeClassState {

    /**
     * Represents the different size buckets for width and height.
     */
    enum class Size {
        /**
         * A compact size, typically for phones in portrait mode.
         */
        COMPAT,

        /**
         * A medium size, typically for tablets in portrait mode or larger phones.
         */
        MEDIUM,

        /**
         * An expanded size, typically for tablets in landscape mode or large screens.
         */
        EXPANDED
    }

    /**
     * Returns the size class for the window's width.
     *
     * @return The [Size] class for the width.
     */
    fun getWidthSize(): Size

    /**
     * Returns the size class for the window's height.
     *
     * @return The [Size] class for the height.
     */
    fun getHeightSize(): Size
}

/**
 * Creates and remembers a [WindowSizeClassState].
 *
 * This function uses [WindowMetricsCalculator] to compute the current window metrics and determine
 * the appropriate size classes.
 *
 * @param context The [Context] to use for calculating window metrics. Defaults to [LocalContext].
 * @return A remembered instance of [WindowSizeClassState].
 */
@Composable
fun windowSizeClassState(
    context: Context = LocalContext.current
): WindowSizeClassState {
    val metrics = WindowMetricsCalculator
        .getOrCreate()
        .computeCurrentWindowMetrics(context)
    val width = metrics.bounds.width()
    val height = metrics.bounds.height()
    val density = context.resources.displayMetrics.density
    return DefaultWindowSizeClassState(
        WindowSizeClass.compute(width / density, height / density)
    )
}

/**
 * The default implementation of [WindowSizeClassState].
 *
 * It uses the [WindowSizeClass] from the AndroidX Window library to determine the size classes.
 *
 * @param windowSizeClass The [WindowSizeClass] instance.
 */
internal class DefaultWindowSizeClassState(
    private val windowSizeClass: WindowSizeClass
) : WindowSizeClassState {

    /**
     * Determines the width size class based on the window's width and predefined breakpoints.
     */
    override fun getWidthSize(): WindowSizeClassState.Size =
        when {
            windowSizeClass.isWidthAtLeastBreakpoint(WIDTH_DP_EXPANDED_LOWER_BOUND) -> WindowSizeClassState.Size.EXPANDED
            windowSizeClass.isWidthAtLeastBreakpoint(WIDTH_DP_MEDIUM_LOWER_BOUND) -> WindowSizeClassState.Size.MEDIUM
            else -> WindowSizeClassState.Size.COMPAT
        }

    /**
     * Determines the height size class based on the window's height and predefined breakpoints.
     */
    override fun getHeightSize(): WindowSizeClassState.Size =
        when {
            windowSizeClass.isHeightAtLeastBreakpoint(HEIGHT_DP_EXPANDED_LOWER_BOUND) -> WindowSizeClassState.Size.EXPANDED
            windowSizeClass.isHeightAtLeastBreakpoint(HEIGHT_DP_MEDIUM_LOWER_BOUND) -> WindowSizeClassState.Size.MEDIUM
            else -> WindowSizeClassState.Size.COMPAT
        }
}
