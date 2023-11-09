package com.santukis.ca.components.scaffold

import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass

abstract class UiState {
    abstract val windowSizeClass: WindowSizeClass

    fun isWindowHeightCompat(): Boolean =
        windowSizeClass.windowHeightSizeClass == WindowHeightSizeClass.COMPACT

    fun isWindowHeightMedium(): Boolean =
        windowSizeClass.windowHeightSizeClass == WindowHeightSizeClass.MEDIUM

    fun isWindowHeightExpanded(): Boolean =
        windowSizeClass.windowHeightSizeClass == WindowHeightSizeClass.EXPANDED

    fun isWindowWidthCompat(): Boolean =
        windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.COMPACT

    fun isWindowWidthMedium(): Boolean =
        windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.MEDIUM

    fun isWindowWidthExpanded(): Boolean =
        windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.EXPANDED
}
