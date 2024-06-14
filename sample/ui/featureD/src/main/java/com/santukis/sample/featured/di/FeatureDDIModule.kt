package com.santukis.sample.featured.di

import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.StateHolder
import com.santukis.injection.providers.koin.KoinDIModule
import com.santukis.sample.featured.landing.FeatureDLandingScreen
import com.santukis.sample.featured.landing.FeatureDLandingViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.binds
import org.koin.dsl.module

class FeatureDDIModule : KoinDIModule() {

    override fun getModule(): Module =
        module {
            scope<FeatureDLandingScreen> {
                viewModelOf(::FeatureDLandingViewModel) binds arrayOf(
                    ActionHandler::class,
                    StateHolder::class
                )
            }
        }
}
