package com.santukis.ca.components.scaffold.states

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import androidx.window.layout.WindowMetricsCalculator

@Composable
fun rememberWindowSizeClassState(
    context: Context = LocalContext.current
): WindowSizeClassState {
    val metrics = WindowMetricsCalculator
        .getOrCreate()
        .computeCurrentWindowMetrics(context)
    val width = metrics.bounds.width()
    val height = metrics.bounds.height()
    val density = context.resources.displayMetrics.density
    return WindowSizeClassState(
        WindowSizeClass.compute(width / density, height / density)
    )
}

class WindowSizeClassState(
    private val windowSizeClass: WindowSizeClass
) {

    enum class Size {
        COMPAT,
        MEDIUM,
        EXPANDED
    }

    fun getWidthSize(): Size =
        when (windowSizeClass.windowWidthSizeClass) {
            WindowWidthSizeClass.COMPACT -> Size.COMPAT
            WindowWidthSizeClass.MEDIUM -> Size.MEDIUM
            else -> Size.EXPANDED
        }

    fun getHeightSize(): Size =
        when (windowSizeClass.windowHeightSizeClass) {
            WindowHeightSizeClass.COMPACT -> Size.COMPAT
            WindowHeightSizeClass.MEDIUM -> Size.MEDIUM
            else -> Size.EXPANDED
        }
}
