package com.santukis.sample.featurea.secondary

import com.santukis.ca.ui.navigation.DestinationTemplate
import com.santukis.ca.ui.navigation.Router
import com.santukis.ca.ui.scaffold.Action
import com.santukis.ca.ui.scaffold.Screen
import com.santukis.ca.ui.scaffold.ScreenDestination
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
