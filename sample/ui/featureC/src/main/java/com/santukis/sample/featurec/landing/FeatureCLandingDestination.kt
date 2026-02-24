package com.santukis.sample.featurec.landing

import com.santukis.ca.ui.navigation.DestinationTemplate
import com.santukis.ca.ui.navigation.Router
import com.santukis.ca.ui.scaffold.Action
import com.santukis.ca.ui.scaffold.Screen
import com.santukis.ca.ui.scaffold.ScreenDestination
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
