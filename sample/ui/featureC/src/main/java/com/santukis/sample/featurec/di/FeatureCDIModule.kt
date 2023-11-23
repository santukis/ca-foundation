package com.santukis.sample.featurec.di

import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.StateHolder
import com.santukis.injection.providers.koin.KoinDIModule
import com.santukis.sample.featurec.landing.FeatureCLandingScreen
import com.santukis.sample.featurec.landing.FeatureCLandingState
import com.santukis.sample.featurec.landing.FeatureCLandingViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.qualifier.TypeQualifier
import org.koin.dsl.module

class FeatureCDIModule : KoinDIModule() {

    override fun getModule(): Module =
        module {
            viewModelOf(::FeatureCLandingViewModel)
            factory<StateHolder<FeatureCLandingState>>(TypeQualifier(FeatureCLandingScreen::class)) {
                get<FeatureCLandingViewModel>()
            }
            factory<ActionHandler>(TypeQualifier(FeatureCLandingScreen::class)) {
                get<FeatureCLandingViewModel>()
            }
        }
}
