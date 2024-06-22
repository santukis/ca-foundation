package com.santukis.sample.featurea.secondary

import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.Screen
import com.santukis.ca.components.scaffold.ScreenDestination
import com.santukis.navigation.DestinationTemplate
import com.santukis.navigation.Router
import com.santukis.sample.featurea.secondary.FeatureASecondaryNavigationAction.GoBack
import com.santukis.sample.featurea.secondary.navigation.FeatureASecondaryDestinationTemplate

class FeatureASecondaryDestination(
    override val router: Router
) : ScreenDestination(router) {

    override val template: DestinationTemplate = FeatureASecondaryDestinationTemplate()

    override fun getScreenDestination(): Screen<*, *> = FeatureASecondaryScreen()

    override fun handle(action: Action) {
        when (action) {
            is GoBack -> router.popBackStack()
        }
    }

}
