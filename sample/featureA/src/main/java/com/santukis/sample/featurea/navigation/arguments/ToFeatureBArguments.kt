package com.santukis.sample.featurea.navigation.arguments

import com.santukis.navigation.DestinationArguments

class ToFeatureBArguments(private val anyParam: String) : DestinationArguments {

    override fun getRoute(): String = "featureB/landing/$anyParam"
}
