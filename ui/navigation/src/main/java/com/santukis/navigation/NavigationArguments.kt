package com.santukis.navigation

import androidx.compose.runtime.Composable

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
