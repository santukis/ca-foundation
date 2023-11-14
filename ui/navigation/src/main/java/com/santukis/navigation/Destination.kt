package com.santukis.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import kotlin.reflect.KClass

@Stable
interface Destination {
    val template: String
}

@Stable
interface ActivityDestination : Destination {
    fun getActivityDestination(): KClass<out Activity>?
}

@Stable
interface ScreenDestination : Destination {

    fun getArguments(): List<NamedNavArgument> = listOf()

    fun getDeepLinks(): List<NavDeepLink> = listOf()

    @Composable
    fun DestinationScreen(
        router: Router,
        backStackEntry: NavBackStackEntry
    )
}
