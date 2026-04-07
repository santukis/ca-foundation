package com.santukis.ca.ui.navigation

import androidx.compose.runtime.Stable

/**
 * Maps arguments to a type that can be stored in a Bundle.
 */
@Stable
interface ArgumentsMapper {

    /**
     * Maps the given [from] argument to a type that can be stored in a Bundle.
     *
     * @param from The argument to map.
     * @return The mapped argument, or null if the argument cannot be mapped.
     */
    fun <Result : Any> map(from: Result): Any?
}
