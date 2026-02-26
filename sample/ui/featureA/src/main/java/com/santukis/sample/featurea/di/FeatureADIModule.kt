package com.santukis.sample.featurea.di

import com.santukis.ca.ui.scaffold.CaViewModel
import com.santukis.injection.koininjection.KoinDIModule
import com.santukis.sample.featurea.landing.FeatureALandingScreen
import com.santukis.sample.featurea.landing.FeatureALandingViewModel
import com.santukis.sample.featurea.secondary.FeatureASecondaryScreen
import com.santukis.sample.featurea.secondary.FeatureASecondaryViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

class FeatureADIModule : KoinDIModule() {

    override fun getModule(): Module =
        module {
            scope<FeatureALandingScreen> {
                viewModelOf(::FeatureALandingViewModel) bind CaViewModel::class
            }


            scope<FeatureASecondaryScreen> {
                viewModelOf(::FeatureASecondaryViewModel) bind CaViewModel::class
            }
        }
}
