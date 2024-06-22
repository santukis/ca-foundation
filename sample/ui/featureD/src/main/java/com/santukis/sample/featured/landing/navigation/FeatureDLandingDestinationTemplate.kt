package com.santukis.sample.featured.landing.navigation

import com.santukis.navigation.DestinationTemplate

class FeatureDLandingDestinationTemplate : DestinationTemplate {

    companion object {
        const val ANY_PARAM_KEY = "anyParam"
    }

    override val template: String = "featureD/landing/{$ANY_PARAM_KEY}"

}