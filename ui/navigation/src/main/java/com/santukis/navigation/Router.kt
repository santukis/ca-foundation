package com.santukis.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.Observer
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.rememberNavController

interface Router {

    fun navigate(arguments: DestinationArguments, builder: NavOptionsBuilder.() -> Unit = {})

    fun popBackStack()

    fun navigateUp()

    fun <Result> navigateForResult(
        arguments: DestinationArgumentsForResult<Result>,
        builder: NavOptionsBuilder.() -> Unit = {}
    )

    /**
     *
     * @throws IllegalArgumentException value cannot be saved in saved state
     */
    fun <Result : Any> setResult(arguments: ResultArguments<Result>)
}

internal class DefaultRouter(
    private val argumentsMapper: DestinationArgumentsMapper,
    private val navController: NavHostController
) : Router {

    companion object {
        private const val navigationKey = "navigationKey"
    }

    override fun navigate(arguments: DestinationArguments, builder: NavOptionsBuilder.() -> Unit) {
        navController.navigate(arguments.getRoute(), builder)
    }

    override fun popBackStack() {
        navController.popBackStack()
    }

    override fun navigateUp() {
        navController.navigateUp()
    }

    override fun <Result> navigateForResult(
        arguments: DestinationArgumentsForResult<Result>,
        builder: NavOptionsBuilder.() -> Unit
    ) {
        val liveData = navController
            .currentBackStackEntry
            ?.savedStateHandle
            ?.getLiveData<Result?>(navigationKey)

        liveData?.observeForever(object : Observer<Result?> {
            override fun onChanged(value: Result?) {
                value?.let {
                    liveData.value = null
                    liveData.removeObserver(this)
                    arguments.onResult(value)
                }
            }
        })

        navigate(arguments, builder)
    }

    override fun <Result : Any> setResult(arguments: ResultArguments<Result>) {
        navController
            .previousBackStackEntry
            ?.savedStateHandle
            ?.set(
                navigationKey,
                argumentsMapper.map(arguments.result)
            )

        popBackStack()
    }
}

@Composable
fun rememberRouter(
    argumentsMapper: DestinationArgumentsMapper,
    navController: NavHostController = rememberNavController(),
): Router = remember(navController) {
    DefaultRouter(
        argumentsMapper,
        navController
    )
}
