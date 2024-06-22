package com.santukis.sample.featured.di

import com.santukis.injection.koininjection.KoinDIModule
import com.santukis.sample.featured.host.FeatureDHostScreen
import com.santukis.sample.featured.host.FeatureDHostViewModel
import com.santukis.sample.featured.landing.FeatureDLandingScreen
import com.santukis.sample.featured.landing.FeatureDLandingViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class FeatureDDIModule : KoinDIModule() {

    override fun getModule(): Module =
        module {
            scope<FeatureDLandingScreen> {
                caViewModelOf(::FeatureDLandingViewModel)
            }

            scope<FeatureDHostScreen> {
                caViewModelOf(::FeatureDHostViewModel)
            }
        }
}
