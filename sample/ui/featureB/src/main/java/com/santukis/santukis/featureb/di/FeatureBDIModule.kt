package com.santukis.santukis.featureb.di

import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.StateHolder
import com.santukis.injection.providers.koin.KoinDIModule
import com.santukis.santukis.featureb.landing.FeatureBLandingScreen
import com.santukis.santukis.featureb.landing.FeatureBLandingState
import com.santukis.santukis.featureb.landing.FeatureBLandingViewModel
import com.santukis.santukis.featureb.secondary.FeatureBSecondaryScreen
import com.santukis.santukis.featureb.secondary.FeatureBSecondaryState
import com.santukis.santukis.featureb.secondary.FeatureBSecondaryViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.qualifier.TypeQualifier
import org.koin.dsl.module

class FeatureBDIModule : KoinDIModule() {

    override fun getModule(): Module =
        module {
            viewModelOf(::FeatureBLandingViewModel)
            factory<StateHolder<FeatureBLandingState>>(TypeQualifier(FeatureBLandingScreen::class)) {
                get<FeatureBLandingViewModel>()
            }
            factory<ActionHandler>(TypeQualifier(FeatureBLandingScreen::class)) {
                get<FeatureBLandingViewModel>()
            }

            viewModelOf(::FeatureBSecondaryViewModel)
            factory<StateHolder<FeatureBSecondaryState>>(TypeQualifier(FeatureBSecondaryScreen::class)) {
                get<FeatureBSecondaryViewModel>()
            }
            factory<ActionHandler>(TypeQualifier(FeatureBSecondaryScreen::class)) {
                get<FeatureBSecondaryViewModel>()
            }
        }
}
