package com.santukis.ca.ui.scaffold.actions

import androidx.compose.runtime.Stable
import com.santukis.ca.ui.scaffold.ScreenAction

/**
 * A [ScreenAction] that represents a request to open the navigation drawer.
 */
@Stable
interface OpenDrawer : ScreenAction

/**
 * A [ScreenAction] that represents a request to close the navigation drawer.
 */
@Stable
interface CloseDrawer : ScreenAction
