package com.santukis.sample.featured.landing

import com.santukis.ca.ui.scaffold.Screen
import com.santukis.ca.ui.scaffold.ScreenDestination
import com.santukis.ca.ui.navigation.DestinationTemplate
import com.santukis.ca.ui.navigation.Router
import com.santukis.sample.featured.landing.navigation.FeatureDLandingDestinationTemplate

class FeatureDLandingDestination(
    override val router: Router
) : ScreenDestination(router) {

    override val template: DestinationTemplate = FeatureDLandingDestinationTemplate()

    override fun getScreenDestination(): Screen<*, *> = FeatureDLandingScreen()
}
