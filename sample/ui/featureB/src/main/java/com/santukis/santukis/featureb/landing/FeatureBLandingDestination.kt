package com.santukis.santukis.featureb.landing

import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.ScreenDestination
import com.santukis.navigation.DestinationTemplate
import com.santukis.navigation.Router
import com.santukis.santukis.featureb.landing.FeatureBLandingNavigationAction.GoBack
import com.santukis.santukis.featureb.landing.FeatureBLandingNavigationAction.NavigateToSecondaryScreen
import com.santukis.santukis.featureb.landing.navigation.FeatureBLandingDestinationTemplate

class FeatureBLandingDestination(
    override val router: Router
) : ScreenDestination(router) {

    override val template: DestinationTemplate = FeatureBLandingDestinationTemplate()

    override fun getScreenDestination(): Screen<*, *> = FeatureBLandingScreen()

    override fun handle(action: Action) {
        when (action) {
            is NavigateToSecondaryScreen -> router.navigateForResult(arguments = action.arguments)
            is GoBack -> router.popBackStack()
        }
    }
}
