package com.santukis.ca.ui.navigation

import androidx.compose.runtime.Stable

/**
 * Represents a set of input arguments for a destination.
 * This class provides a way to retrieve arguments in a type-safe manner.
 */
@Stable
abstract class InputArguments {

    /**
     * A key to retrieve a specific argument from an [InputArguments] container.
     *
     * @param Type The type of the arguments container (e.g., a Bundle or a custom data class).
     * @param Value The type of the value to retrieve.
     */
    interface ArgumentKey<Type, Value> {

        /**
         * Retrieves the value for this key from the given [arguments] container.
         *
         * @param arguments The arguments container.
         * @return The retrieved value, or null if not found.
         */
        fun getValue(arguments: Type?): Value?
    }

    /**
     * Retrieves the value for the given [key].
     *
     * @param key The key to look up.
     * @return The value associated with the key, or null if not found.
     */
    abstract fun <Type, Value> getValue(
        key: ArgumentKey<Type, Value>
    ) : Value?

    /**
     * Combines this [InputArguments] with another one.
     * The [other] arguments will be checked first when retrieving a value.
     *
     * @param other The [InputArguments] to combine with.
     * @return A new [CombinedArguments] instance.
     */
    operator fun plus(other: InputArguments): InputArguments =
        CombinedArguments(
            inner = other,
            outer = this
        )
}

/**
 * An [InputArguments] implementation that wraps a specific arguments object.
 *
 * @param Type The type of the wrapped arguments object.
 * @param arguments The arguments object.
 */
class ScreenArguments<Type>(
    private val arguments: Type
) : InputArguments() {

    /**
     * Retrieves a value from the wrapped arguments object using the provided [key].
     * It safely casts the wrapped arguments to the type expected by the key.
     */
    override fun <Type, Value> getValue(
        key: ArgumentKey<Type, Value>
    ): Value? = try {
        key.getValue(arguments as? Type)

    } catch (exception: Exception) {
        null
    }
}

/**
 * An [InputArguments] implementation that combines two other [InputArguments].
 * It allows chaining argument lookups.
 *
 * @param inner The primary [InputArguments] to check first.
 * @param outer The secondary [InputArguments] to check if the value is not in the inner one.
 */
class CombinedArguments(
    val inner: InputArguments,
    val outer: InputArguments
) : InputArguments() {

    /**
     * Retrieves a value by first looking in the [inner] arguments, and then falling back to the [outer] arguments.
     */
    override fun <Type, Value> getValue(
        key: ArgumentKey<Type, Value>
    ): Value? = inner.getValue(key) ?: outer.getValue(key)
}
