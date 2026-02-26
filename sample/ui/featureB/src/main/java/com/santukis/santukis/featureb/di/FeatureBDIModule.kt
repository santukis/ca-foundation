package com.santukis.santukis.featureb.di

import com.santukis.ca.ui.scaffold.CaViewModel
import com.santukis.injection.koininjection.KoinDIModule
import com.santukis.santukis.featureb.landing.FeatureBLandingScreen
import com.santukis.santukis.featureb.landing.FeatureBLandingViewModel
import com.santukis.santukis.featureb.secondary.FeatureBSecondaryScreen
import com.santukis.santukis.featureb.secondary.FeatureBSecondaryViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

class FeatureBDIModule : KoinDIModule() {

    override fun getModule(): Module =
        module {
            scope<FeatureBLandingScreen> {
                viewModelOf(::FeatureBLandingViewModel) bind CaViewModel::class
            }

            scope<FeatureBSecondaryScreen> {
                viewModelOf(::FeatureBSecondaryViewModel) bind CaViewModel::class
            }
        }
}
