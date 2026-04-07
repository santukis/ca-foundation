package com.santukis.ca.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.lifecycle.Observer
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.rememberNavController
import org.koin.ext.getFullName

/**
 * Defines the contract for a navigation router.
 * A router is responsible for handling navigation between different destinations in the application.
 */
@Stable
interface Router {

    /**
     * Returns the underlying [NavHostController] used for navigation.
     */
    fun getNavController(): NavHostController

    /**
     * Navigates to a destination specified by the [arguments].
     *
     * @param arguments The [DestinationArguments] defining the destination and any parameters.
     * @param builder An optional lambda to configure [NavOptionsBuilder] for this navigation.
     */
    fun navigate(
        arguments: DestinationArguments,
        builder: NavOptionsBuilder.() -> Unit = {}
    )

    /**
     * Pops the current destination from the back stack.
     */
    fun popBackStack()

    /**
     * Navigates up in the navigation hierarchy.
     */
    fun navigateUp()

    /**
     * Navigates to a destination for a result.
     *
     * @param Result The type of the expected result.
     * @param arguments The [DestinationArgumentsForResult] defining the destination and the result callback.
     * @param builder An optional lambda to configure [NavOptionsBuilder] for this navigation.
     */
    fun <Result> navigateForResult(
        arguments: DestinationArgumentsForResult<Result>,
        builder: NavOptionsBuilder.() -> Unit = {}
    )

    /**
     * Sets a result to be delivered to the previous destination that is expecting it.
     *
     * @param Result The type of the result.
     * @param arguments The [ResultArguments] containing the result data.
     * @throws IllegalArgumentException if the result value cannot be saved in the saved state.
     */
    fun <Result : Any> setResult(arguments: ResultArguments<Result>)
}

/**
 * The default implementation of the [Router] interface.
 * It uses a [NavHostController] to perform navigation.
 *
 * @param navController The [NavHostController] to use for navigation.
 * @param argumentsMapper The [ArgumentsMapper] to map result arguments.
 */
internal class DefaultRouter(
    private val navController: NavHostController,
    private val argumentsMapper: ArgumentsMapper,
) : Router {

    private var navigationKey = "navigationKey"

    override fun getNavController(): NavHostController = navController

    @Suppress("SwallowedException")
    override fun navigate(
        arguments: DestinationArguments,
        builder: NavOptionsBuilder.() -> Unit
    ) = try {
        navController.navigate(arguments.getRoute(), builder)
    } catch (exception: IllegalArgumentException) {
        // no-op, this can happen if the destination is not found,
        // which can be valid in some cases where a feature is not installed.
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
        // Generate a unique key for this navigation request to avoid conflicts.
        navigationKey = arguments::class.getFullName() + "@" + System.identityHashCode(arguments)
        val liveData = navController
            .currentBackStackEntry
            ?.savedStateHandle
            ?.getLiveData<Result?>(navigationKey)

        // Observe for the result.
        liveData?.observeForever(object : Observer<Result?> {
            override fun onChanged(value: Result?) {
                value?.let {
                    // Clear the value in LiveData to avoid delivering the same result again.
                    liveData.value = null
                    // Stop observing.
                    liveData.removeObserver(this)
                    // Deliver the result.
                    arguments.onResult(it)
                }
            }
        })

        // Perform the navigation.
        navigate(arguments, builder)
    }

    override fun <Result : Any> setResult(arguments: ResultArguments<Result>) {
        // Set the result on the SavedStateHandle of the previous back stack entry.
        navController
            .previousBackStackEntry
            ?.savedStateHandle
            ?.set(
                navigationKey,
                argumentsMapper.map(arguments.result)
            )

        // Pop the current screen to go back to the previous one.
        popBackStack()
    }
}

/**
 * A Composable function that remembers a [Router] instance.
 *
 * @param argumentsMapper The [ArgumentsMapper] to be used by the router.
 * @param navController The [NavHostController] to be used by the router. Defaults to a new controller remembered by `rememberNavController()`.
 * @return A remembered [Router] instance.
 */
@Composable
fun rememberRouter(
    argumentsMapper: ArgumentsMapper,
    navController: NavHostController = rememberNavController(),
): Router = remember(argumentsMapper, navController) {
    DefaultRouter(
        navController = navController,
        argumentsMapper = argumentsMapper,
    )
}
