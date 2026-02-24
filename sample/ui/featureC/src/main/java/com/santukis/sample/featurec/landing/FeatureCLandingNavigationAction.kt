package com.santukis.sample.featurec.landing

import com.santukis.ca.ui.navigation.NavigationArguments
import com.santukis.ca.ui.scaffold.NavigationAction
import com.santukis.sample.featurec.landing.navigation.ToFeatureAResultArguments

sealed class FeatureCLandingNavigationAction<Arguments : NavigationArguments>(
    val arguments: Arguments
) : NavigationAction {

    class NavigateToFeatureAScreen(arguments: ToFeatureAResultArguments) :
        FeatureCLandingNavigationAction<ToFeatureAResultArguments>(arguments)
}
