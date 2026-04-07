package com.santukis.ca.ui.navigation

import android.app.Activity
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.navigation.NavBackStackEntry
import kotlin.reflect.KClass

/**
 * Represents a destination in the navigation graph.
 */
@Stable
interface Destination {

    /**
     * The template for the destination's route.
     */
    val template: DestinationTemplate
}

/**
 * Represents a destination that is an Activity.
 */
@Stable
interface ActivityDestination : Destination {

    /**
     * Returns the [KClass] of the Activity to navigate to.
     */
    fun getActivityDestination(): KClass<out Activity>?
}

/**
 * Represents a destination that is a Composable screen.
 */
@Stable
interface ComposableDestination : Destination {

    /**
     * The [Router] used for navigation.
     */
    val router: Router

    /**
     * The Composable content of the destination screen.
     *
     * @param arguments The input arguments for the screen.
     */
    @Composable
    fun DestinationScreen(arguments: InputArguments)

    /**
     * Defines the enter transition for the destination.
     * By default, it's a fade-in animation.
     */
    fun enterTransition(): (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        { fadeIn(animationSpec = tween(700)) }

    /**
     * Defines the exit transition for the destination.
     * By default, it's a fade-out animation.
     */
    fun exitTransition(): (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        { fadeOut(animationSpec = tween(700)) }

    /**
     * Defines the pop enter transition for the destination.
     * By default, it's the same as the [enterTransition].
     */
    fun popEnterTransition(): (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        enterTransition()

    /**
     * Defines the pop exit transition for the destination.
     * By default, it's the same as the [exitTransition].
     */
    fun popExitTransition(): (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        exitTransition()
}
