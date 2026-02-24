package com.santukis.sample.featured.landing

import com.santukis.ca.ui.scaffold.NavigationAction
import com.santukis.ca.ui.navigation.NavigationArguments
import com.santukis.sample.featured.landing.navigation.ToFeatureADestinationArguments

sealed class FeatureDLandingNavigationAction<Arguments : NavigationArguments>(
    val arguments: Arguments
) : NavigationAction {

    class NavigateToFeatureAScreen(arguments: ToFeatureADestinationArguments) :
        FeatureDLandingNavigationAction<ToFeatureADestinationArguments>(arguments)
}
