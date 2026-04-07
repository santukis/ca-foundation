package com.santukis.ca.ui.scaffold

import androidx.compose.runtime.Stable

/**
 * A marker interface for all actions that can be triggered in the application.
 * Actions are used to communicate events from the UI to the ViewModel or other handlers.
 */
@Stable
interface Action

/**
 * A marker interface for actions that are specific to a screen.
 * These actions are typically handled by the ViewModel of the screen.
 */
@Stable
interface ScreenAction : Action

/**
 * A marker interface for actions that trigger navigation.
 * These actions are typically handled by a navigation component, such as a Router.
 */
@Stable
interface NavigationAction : Action
