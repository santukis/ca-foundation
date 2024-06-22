package com.santukis.sample.featurea.landing

import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.ScreenDestination
import com.santukis.navigation.DestinationTemplate
import com.santukis.navigation.Router
import com.santukis.sample.featurea.landing.FeatureALandingNavigationAction.NavigateToFeatureB
import com.santukis.sample.featurea.landing.FeatureALandingNavigationAction.NavigateToFeatureC
import com.santukis.sample.featurea.landing.FeatureALandingNavigationAction.NavigateToFeatureD
import com.santukis.sample.featurea.landing.FeatureALandingNavigationAction.NavigateToSecondaryScreen
import com.santukis.sample.featurea.landing.navigation.FeatureALandingDestinationTemplate

class FeatureALandingDestination(
    override val router: Router
) : ScreenDestination(router) {

    override val template: DestinationTemplate = FeatureALandingDestinationTemplate()

    override fun getScreenDestination(): Screen<*, *> = FeatureALandingScreen()

    override fun handle(action: Action) {
        when (action) {
            is NavigateToFeatureB -> router.navigate(action.arguments)
            is NavigateToFeatureC -> router.navigateForResult(action.arguments)
            is NavigateToFeatureD -> router.navigate(action.arguments)
            is NavigateToSecondaryScreen -> router.navigate(action.arguments)
        }
    }
}
