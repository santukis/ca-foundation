package com.santukis.sample.featured.landing

import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.ScreenDestination
import com.santukis.navigation.DestinationTemplate
import com.santukis.navigation.Router
import com.santukis.sample.featured.landing.navigation.FeatureDLandingDestinationTemplate

class FeatureDLandingDestination(
    override val router: Router
) : ScreenDestination(router) {

    override val template: DestinationTemplate = FeatureDLandingDestinationTemplate()

    override fun getScreenDestination(): Screen<*, *> = FeatureDLandingScreen()
}
