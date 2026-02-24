package com.santukis.santukis.featureb.landing.navigation

import com.santukis.ca.ui.navigation.DestinationArgumentsForResult

class ToSecondaryScreenArguments(
    override val onResult: (String) -> Unit
) : DestinationArgumentsForResult<String> {

    override fun getRoute(): String = "featureB/secondary"
}
