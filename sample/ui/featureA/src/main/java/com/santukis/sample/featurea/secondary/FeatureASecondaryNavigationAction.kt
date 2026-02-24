package com.santukis.sample.featurea.secondary

import com.santukis.ca.ui.navigation.NavigationArguments
import com.santukis.ca.ui.navigation.PopBackStack
import com.santukis.ca.ui.scaffold.NavigationAction

sealed class FeatureASecondaryNavigationAction<Arguments : NavigationArguments>(
    val arguments: Arguments
) : NavigationAction {

    class GoBack : FeatureASecondaryNavigationAction<PopBackStack>(PopBackStack)
}
