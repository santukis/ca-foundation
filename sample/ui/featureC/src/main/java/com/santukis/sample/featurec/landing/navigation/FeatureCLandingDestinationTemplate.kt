package com.santukis.sample.featurec.landing.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.santukis.navigation.DestinationTemplate

class FeatureCLandingDestinationTemplate : DestinationTemplate {

    companion object {
        const val ANY_PARAM_KEY = "anyParam"
    }

    override val template: String
        get() = "featureC/landing/{$ANY_PARAM_KEY}"

    override fun getArguments(): List<NamedNavArgument> =
        listOf(
            navArgument(ANY_PARAM_KEY) {
                type = NavType.StringType
                defaultValue = ""
            }
        )

}