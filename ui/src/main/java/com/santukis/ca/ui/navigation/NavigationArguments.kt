package com.santukis.ca.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
interface NavigationArguments

interface DestinationArguments : NavigationArguments {

    fun getRoute(): String = ""
}

object PopBackStack : DestinationArguments

interface DestinationArgumentsForResult<Result> : DestinationArguments {

    val onResult: (Result) -> Unit
}

interface BottomNavigationDestinationArguments : DestinationArguments {

    @Composable
    fun BottomNavigationItemTitle()

    @Composable
    fun BottomNavigationItemIcon()
}

interface ResultArguments<Result> : NavigationArguments {

    val result: Result
}
