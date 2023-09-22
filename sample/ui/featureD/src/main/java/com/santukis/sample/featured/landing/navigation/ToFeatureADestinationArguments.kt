package com.santukis.sample.featured.landing.navigation

import com.santukis.navigation.DestinationArguments

class ToFeatureADestinationArguments(
    private val result: String
) : DestinationArguments {

    override fun getRoute(): String = "featureA/landing?result=$result"
}
