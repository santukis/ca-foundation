package com.santukis.sample.featurea.landing.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.santukis.navigation.DestinationTemplate

class FeatureALandingDestinationTemplate : DestinationTemplate {

    companion object {
        const val FEATURE_D_RESULT = "result"
    }

    override val template: String = "featureA/landing?result={result}"

    override fun getArguments(): List<NamedNavArgument> =
        listOf(
            navArgument(FEATURE_D_RESULT) {
                type = NavType.StringType
            }
        )
}