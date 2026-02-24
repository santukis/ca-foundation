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

interface WindowSizeClassState {

    enum class Size {
        COMPAT,
        MEDIUM,
        EXPANDED
    }

    fun getWidthSize(): Size

    fun getHeightSize(): Size
}

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

internal class DefaultWindowSizeClassState(
    private val windowSizeClass: WindowSizeClass
) : WindowSizeClassState {

    override fun getWidthSize(): WindowSizeClassState.Size =
        when {
            windowSizeClass.isWidthAtLeastBreakpoint(WIDTH_DP_EXPANDED_LOWER_BOUND) -> WindowSizeClassState.Size.EXPANDED
            windowSizeClass.isWidthAtLeastBreakpoint(WIDTH_DP_MEDIUM_LOWER_BOUND) -> WindowSizeClassState.Size.MEDIUM
            else -> WindowSizeClassState.Size.COMPAT
        }

    override fun getHeightSize(): WindowSizeClassState.Size =
        when {
            windowSizeClass.isHeightAtLeastBreakpoint(HEIGHT_DP_EXPANDED_LOWER_BOUND) -> WindowSizeClassState.Size.EXPANDED
            windowSizeClass.isHeightAtLeastBreakpoint(HEIGHT_DP_MEDIUM_LOWER_BOUND) -> WindowSizeClassState.Size.MEDIUM
            else -> WindowSizeClassState.Size.COMPAT
        }
}
