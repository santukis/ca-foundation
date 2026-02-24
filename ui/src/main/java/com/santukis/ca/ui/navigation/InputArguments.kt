package com.santukis.ca.ui.navigation

import androidx.compose.runtime.Stable

@Stable
abstract class InputArguments {

    interface ArgumentKey<Type, Value> {
        fun getValue(arguments: Type?): Value?
    }

    abstract fun <Type, Value> getValue(
        key: ArgumentKey<Type, Value>
    ) : Value?

    operator fun plus(other: InputArguments): InputArguments =
        CombinedArguments(
            inner = other,
            outer = this
        )
}

class ScreenArguments<Type>(
    private val arguments: Type
) : InputArguments() {

    override fun <Type, Value> getValue(
        key: ArgumentKey<Type, Value>
    ): Value? = try {
        key.getValue(arguments as? Type)

    } catch (exception: Exception) {
        null
    }
}

class CombinedArguments(
    val inner: InputArguments,
    val outer: InputArguments
) : InputArguments() {

    override fun <Type, Value> getValue(
        key: ArgumentKey<Type, Value>
    ): Value? = inner.getValue(key) ?: outer.getValue(key)
}
