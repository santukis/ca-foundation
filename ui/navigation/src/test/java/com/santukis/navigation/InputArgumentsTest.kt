package com.santukis.navigation

import org.junit.Test

internal class InputArgumentsTest {

    @Test
    fun inputArguments() {
        val arguments = ScreenArguments("first")
        val arguments2 = ScreenArguments("second")
        val arguments3 = ScreenArguments("third")
        val arguments4 = ScreenArguments(4)

        val combinedArguments = arguments + arguments2 + arguments3 + arguments4

        assert(combinedArguments.getValue(StringArgumentKey()) == "first")
    }

    internal class StringArgumentKey : InputArguments.ArgumentKey<String, String> {

        override fun getValue(arguments: String?): String? = arguments.takeIf { it == "first" }


    }
}