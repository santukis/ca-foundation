package com.santukis.sample.featurea.landing

import com.santukis.ca.components.scaffold.ScreenAction

sealed class FeatureALandingAction : ScreenAction {

    class UpdateField01(val value: String) : FeatureALandingAction()
    class UpdateField02(val value: Int) : FeatureALandingAction()
    class UpdateField03(val value: Boolean) : FeatureALandingAction()
    class UpdateField04(val value: List<String>) : FeatureALandingAction()
    class UpdateField05(val value: FeatureALandingState.LandingItem) : FeatureALandingAction()
    class UpdateField06(val value: FeatureALandingItem) : FeatureALandingAction()
}
