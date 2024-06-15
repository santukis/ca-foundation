package com.santukis.santukis.featureb.di

import com.santukis.injection.koininjection.KoinDIModule
import com.santukis.santukis.featureb.landing.FeatureBLandingScreen
import com.santukis.santukis.featureb.landing.FeatureBLandingViewModel
import com.santukis.santukis.featureb.secondary.FeatureBSecondaryScreen
import com.santukis.santukis.featureb.secondary.FeatureBSecondaryViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class FeatureBDIModule : KoinDIModule() {

    override fun getModule(): Module =
        module {
            scope<FeatureBLandingScreen> {
                caViewModelOf(::FeatureBLandingViewModel)
            }

            scope<FeatureBSecondaryScreen> {
                caViewModelOf(::FeatureBSecondaryViewModel)
            }
        }
}
