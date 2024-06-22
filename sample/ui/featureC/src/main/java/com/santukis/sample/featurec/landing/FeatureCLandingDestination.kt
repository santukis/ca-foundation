package com.santukis.sample.featurec.landing

import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.ScreenDestination
import com.santukis.navigation.DestinationTemplate
import com.santukis.navigation.Router
import com.santukis.sample.featurec.landing.FeatureCLandingNavigationAction.NavigateToFeatureAScreen
import com.santukis.sample.featurec.landing.navigation.FeatureCLandingDestinationTemplate

class FeatureCLandingDestination(
    override val router: Router
) : ScreenDestination(router) {

    override val template: DestinationTemplate = FeatureCLandingDestinationTemplate()

    override fun getScreenDestination(): Screen<*, *> = FeatureCLandingScreen()

    override fun handle(action: Action) {
        when (action) {
            is NavigateToFeatureAScreen -> router.setResult(arguments = action.arguments)
        }
    }
}
