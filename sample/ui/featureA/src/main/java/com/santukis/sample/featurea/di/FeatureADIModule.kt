package com.santukis.sample.featurea.di

import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.StateHolder
import com.santukis.injection.providers.koin.KoinDIModule
import com.santukis.sample.featurea.landing.FeatureALandingAction
import com.santukis.sample.featurea.landing.FeatureALandingScreen
import com.santukis.sample.featurea.landing.FeatureALandingState
import com.santukis.sample.featurea.landing.FeatureALandingViewModel
import com.santukis.sample.featurea.secondary.FeatureASecondaryAction
import com.santukis.sample.featurea.secondary.FeatureASecondaryScreen
import com.santukis.sample.featurea.secondary.FeatureASecondaryState
import com.santukis.sample.featurea.secondary.FeatureASecondaryViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.qualifier.TypeQualifier
import org.koin.dsl.module

class FeatureADIModule : KoinDIModule() {

    override fun getModule(): Module =
        module {
            viewModelOf(::FeatureALandingViewModel)
            factory<StateHolder<FeatureALandingState>>(TypeQualifier(FeatureALandingScreen::class)) {
                get<FeatureALandingViewModel>()
            }
            factory<ActionHandler>(TypeQualifier(FeatureALandingScreen::class)) {
                get<FeatureALandingViewModel>()
            }

            viewModelOf(::FeatureASecondaryViewModel)
            factory<StateHolder<FeatureASecondaryState>>(TypeQualifier(FeatureASecondaryScreen::class)) {
                get<FeatureASecondaryViewModel>()
            }
            factory<ActionHandler>(TypeQualifier(FeatureASecondaryScreen::class)) {
                get<FeatureASecondaryViewModel>()
            }
        }
}
