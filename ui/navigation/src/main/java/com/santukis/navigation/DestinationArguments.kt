package com.santukis.navigation

interface NavigationArguments

interface DestinationArguments : NavigationArguments {

    fun getRoute(): String = ""
}

object PopBackStack : DestinationArguments

interface DestinationArgumentsForResult<Result> : DestinationArguments {

    val onResult: (Result) -> Unit
}

interface ResultArguments<Result> : NavigationArguments {

    val result: Result
}
