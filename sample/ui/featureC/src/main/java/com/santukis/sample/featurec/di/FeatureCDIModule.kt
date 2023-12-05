package com.santukis.sample.featurec.di

import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.StateHolder
import com.santukis.injection.providers.koin.KoinDIModule
import com.santukis.sample.featurec.landing.FeatureCLandingScreen
import com.santukis.sample.featurec.landing.FeatureCLandingViewModel
import org.koin.core.module.Module
import org.koin.dsl.binds
import org.koin.dsl.module

class FeatureCDIModule : KoinDIModule() {

    override fun getModule(): Module =
        module {
            scope<FeatureCLandingScreen> {
                scoped { FeatureCLandingViewModel() } binds arrayOf(
                    ActionHandler::class,
                    StateHolder::class
                )
            }
        }
}
