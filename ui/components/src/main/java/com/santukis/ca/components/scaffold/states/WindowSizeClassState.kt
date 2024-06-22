package com.santukis.ca.components.scaffold.states

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
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
        when (windowSizeClass.windowWidthSizeClass) {
            WindowWidthSizeClass.COMPACT -> WindowSizeClassState.Size.COMPAT
            WindowWidthSizeClass.MEDIUM -> WindowSizeClassState.Size.MEDIUM
            else -> WindowSizeClassState.Size.EXPANDED
        }

    override fun getHeightSize(): WindowSizeClassState.Size =
        when (windowSizeClass.windowHeightSizeClass) {
            WindowHeightSizeClass.COMPACT -> WindowSizeClassState.Size.COMPAT
            WindowHeightSizeClass.MEDIUM -> WindowSizeClassState.Size.MEDIUM
            else -> WindowSizeClassState.Size.EXPANDED
        }
}
