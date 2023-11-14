package com.santukis.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Observer
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.DialogNavigator
import org.koin.ext.getFullName

@Stable
interface Router {

    fun getNavController(): NavHostController

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
    context: Context,
    private val argumentsMapper: ArgumentsMapper
) : Router {

    private var navigationKey = "navigationKey"

    private val navController: NavHostController = createNavController(context)

    override fun getNavController(): NavHostController = navController

    @Suppress("SwallowedException")
    override fun navigate(arguments: DestinationArguments, builder: NavOptionsBuilder.() -> Unit) =
        try {
            navController.navigate(arguments.getRoute(), builder)
        } catch (exception: IllegalArgumentException) {
            // no-op
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
        navigationKey = arguments::class.getFullName() + "@" + System.identityHashCode(arguments)
        val liveData = navController
            .currentBackStackEntry
            ?.savedStateHandle
            ?.getLiveData<Result?>(navigationKey)

        liveData?.observeForever(object : Observer<Result?> {
            override fun onChanged(value: Result?) {
                value?.let {
                    liveData.value = null
                    liveData.removeObserver(this)
                    arguments.onResult(it)
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

    private fun createNavController(context: Context) =
        NavHostController(context).apply {
            navigatorProvider.addNavigator(ComposeNavigator())
            navigatorProvider.addNavigator(DialogNavigator())
        }
}

object RouterProvider {

    fun provide(
        context: Context,
        argumentsMapper: ArgumentsMapper,
    ): Router = DefaultRouter(context, argumentsMapper)
}

@Composable
fun rememberRouter(
    argumentsMapper: ArgumentsMapper,
    context: Context = LocalContext.current
): Router = remember(argumentsMapper) {
    DefaultRouter(
        context,
        argumentsMapper
    )
}
