package com.santukis.sample.featurec.di

import com.santukis.injection.koininjection.KoinDIModule
import com.santukis.sample.featurec.landing.FeatureCLandingScreen
import com.santukis.sample.featurec.landing.FeatureCLandingViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class FeatureCDIModule : KoinDIModule() {

    override fun getModule(): Module =
        module {
            scope<FeatureCLandingScreen> {
                caViewModelOf(::FeatureCLandingViewModel)
            }
        }
}
