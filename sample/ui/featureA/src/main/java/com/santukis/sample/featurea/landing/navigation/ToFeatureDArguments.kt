package com.santukis.sample.featurea.landing.navigation

import com.santukis.ca.ui.navigation.DestinationArguments

class ToFeatureDArguments(
    private val anyParam: String,
) : DestinationArguments {

    override fun getRoute(): String = "featureD/host/$anyParam"
}
