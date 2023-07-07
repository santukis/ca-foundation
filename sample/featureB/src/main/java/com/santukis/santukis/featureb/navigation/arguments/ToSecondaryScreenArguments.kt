package com.santukis.santukis.featureb.navigation.arguments

import com.santukis.navigation.DestinationArgumentsForResult

class ToSecondaryScreenArguments(
    override val onResult: (String) -> Unit
) : DestinationArgumentsForResult<String> {

    override fun getRoute(): String = "featureB/secondary"
}