package com.santukis.sample.featurec.di

import com.santukis.ca.ui.scaffold.CaViewModel
import com.santukis.injection.koininjection.KoinDIModule
import com.santukis.sample.featurec.landing.FeatureCLandingScreen
import com.santukis.sample.featurec.landing.FeatureCLandingViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

class FeatureCDIModule : KoinDIModule() {

    override fun getModule(): Module =
        module {
            scope<FeatureCLandingScreen> {
                viewModelOf(::FeatureCLandingViewModel) bind CaViewModel::class
            }
        }
}
