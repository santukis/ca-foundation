package com.santukis.sample.featurea.secondary

import com.santukis.ca.components.scaffold.NavigationAction
import com.santukis.navigation.NavigationArguments
import com.santukis.navigation.PopBackStack

sealed class FeatureASecondaryNavigationAction<Arguments : NavigationArguments>(
    val arguments: Arguments
) : NavigationAction {

    class GoBack : FeatureASecondaryNavigationAction<PopBackStack>(PopBackStack)
}
