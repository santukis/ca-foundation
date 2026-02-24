package com.santukis.sample.featured.host.navigation

import com.santukis.ca.ui.navigation.DestinationTemplate

class FeatureDHostDestinationTemplate : DestinationTemplate {

    companion object {
        const val ANY_PARAM_KEY = "anyParam"
    }

    override val template: String = "featureD/host/{$ANY_PARAM_KEY}"

}