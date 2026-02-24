package com.santukis.sample.featurea.landing

import com.santukis.ca.ui.scaffold.NavigationAction
import com.santukis.ca.ui.navigation.NavigationArguments
import com.santukis.sample.featurea.landing.navigation.ToFeatureBArguments
import com.santukis.sample.featurea.landing.navigation.ToFeatureCArguments
import com.santukis.sample.featurea.landing.navigation.ToFeatureDArguments
import com.santukis.sample.featurea.landing.navigation.ToSecondaryScreenArguments

sealed class FeatureALandingNavigationAction<Arguments : NavigationArguments>(
    val arguments: Arguments
) : NavigationAction {

    class NavigateToFeatureB(arguments: ToFeatureBArguments) :
        FeatureALandingNavigationAction<ToFeatureBArguments>(arguments)

    class NavigateToFeatureC(arguments: ToFeatureCArguments) :
        FeatureALandingNavigationAction<ToFeatureCArguments>(arguments)

    class NavigateToFeatureD(arguments: ToFeatureDArguments) :
        FeatureALandingNavigationAction<ToFeatureDArguments>(arguments)

    class NavigateToSecondaryScreen(arguments: ToSecondaryScreenArguments) :
        FeatureALandingNavigationAction<ToSecondaryScreenArguments>(arguments)
}
