package com.santukis.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import kotlin.reflect.KClass

interface Destination {
    val template: String
}

interface ActivityDestination : Destination {
    fun getActivityDestination(): KClass<out Activity>?
}

interface ScreenDestination : Destination {

    fun getArguments(): List<NamedNavArgument> = listOf()

    fun getDeepLinks(): List<NavDeepLink> = listOf()

    @Composable
    fun DestinationScreen(
        router: Router,
        backStackEntry: NavBackStackEntry
    )
}
