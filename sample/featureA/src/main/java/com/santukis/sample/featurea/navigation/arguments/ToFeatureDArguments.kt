package com.santukis.sample.featurea.navigation.arguments

import com.santukis.navigation.DestinationArgumentsForResult

class ToFeatureDArguments(
    private val anyParam: String,
    override val onResult: (String) -> Unit,
) : DestinationArgumentsForResult<String> {

    override fun getRoute(): String = "featureD/landing/$anyParam"
}
