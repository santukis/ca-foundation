package com.santukis.santukis.featureb.landing

import com.santukis.ca.components.scaffold.NavigationAction
import com.santukis.navigation.NavigationArguments
import com.santukis.navigation.PopBackStack
import com.santukis.santukis.featureb.landing.navigation.ToSecondaryScreenArguments

sealed class FeatureBLandingNavigationAction<Arguments : NavigationArguments>(
    val arguments: Arguments
) : NavigationAction {

    class NavigateToSecondaryScreen(arguments: ToSecondaryScreenArguments) :
        FeatureBLandingNavigationAction<ToSecondaryScreenArguments>(arguments)

    class GoBack : FeatureBLandingNavigationAction<PopBackStack>(PopBackStack)
}
