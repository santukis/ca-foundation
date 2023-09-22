package com.santukis.santukis.featureb.secondary

import com.santukis.ca.components.scaffold.NavigationAction
import com.santukis.navigation.NavigationArguments
import com.santukis.santukis.featureb.landing.navigation.ToFeatureBLandingResultArguments

sealed class FeatureBSecondaryNavigationAction<Arguments : NavigationArguments>(
    val arguments: Arguments
) : NavigationAction {

    class NavigateToFeatureBLanding(arguments: ToFeatureBLandingResultArguments) :
        FeatureBSecondaryNavigationAction<ToFeatureBLandingResultArguments>(arguments)
}
