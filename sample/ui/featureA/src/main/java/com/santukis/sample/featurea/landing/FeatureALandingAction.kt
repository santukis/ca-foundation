package com.santukis.sample.featurea.landing

import com.santukis.ca.ui.scaffold.ScreenAction
import com.santukis.ca.ui.scaffold.actions.CloseDrawer
import com.santukis.ca.ui.scaffold.actions.OpenDrawer

sealed class FeatureALandingAction : ScreenAction {

    class UpdateField01(val value: String) : FeatureALandingAction()
    class UpdateField02(val value: Int) : FeatureALandingAction()
    class UpdateField03(val value: Boolean) : FeatureALandingAction()
    class UpdateField04(val value: List<String>) : FeatureALandingAction()
    class UpdateField05(val value: FeatureALandingState.LandingItem) : FeatureALandingAction()
    class UpdateField06(val value: FeatureALandingItem) : FeatureALandingAction()

    object OpenNavigationDrawer : FeatureALandingAction(), OpenDrawer
    object CloseNavigationDrawer : FeatureALandingAction(), CloseDrawer
}
