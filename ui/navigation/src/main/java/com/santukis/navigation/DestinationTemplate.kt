package com.santukis.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink

interface DestinationTemplate {

    val template: String

    fun getArguments(): List<NamedNavArgument> = listOf()

    fun getDeepLinks(): List<NavDeepLink> = listOf()
}