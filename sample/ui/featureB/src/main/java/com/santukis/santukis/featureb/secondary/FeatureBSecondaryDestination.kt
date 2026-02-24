package com.santukis.santukis.featureb.secondary

import com.santukis.ca.ui.navigation.DestinationTemplate
import com.santukis.ca.ui.navigation.Router
import com.santukis.ca.ui.scaffold.Action
import com.santukis.ca.ui.scaffold.Screen
import com.santukis.ca.ui.scaffold.ScreenDestination
import com.santukis.santukis.featureb.secondary.FeatureBSecondaryNavigationAction.NavigateToFeatureBLanding
import com.santukis.santukis.featureb.secondary.navigation.FeatureBSecondaryDestinationTemplate

class FeatureBSecondaryDestination(
    override val router: Router
) : ScreenDestination(router) {

    override val template: DestinationTemplate = FeatureBSecondaryDestinationTemplate()

    override fun getScreenDestination(): Screen<*, *> = FeatureBSecondaryScreen()

    override fun handle(action: Action) {
        when (action) {
            is NavigateToFeatureBLanding -> router.setResult(action.arguments)
        }
    }
}
