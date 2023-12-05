package com.santukis.sample.featurea.di

import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.StateHolder
import com.santukis.injection.providers.koin.KoinDIModule
import com.santukis.sample.featurea.landing.FeatureALandingScreen
import com.santukis.sample.featurea.landing.FeatureALandingViewModel
import com.santukis.sample.featurea.secondary.FeatureASecondaryScreen
import com.santukis.sample.featurea.secondary.FeatureASecondaryViewModel
import org.koin.core.module.Module
import org.koin.dsl.binds
import org.koin.dsl.module

class FeatureADIModule : KoinDIModule() {

    override fun getModule(): Module =
        module {
            scope<FeatureALandingScreen> {
                scoped { FeatureALandingViewModel() } binds arrayOf(
                    ActionHandler::class,
                    StateHolder::class
                )
            }

            scope<FeatureASecondaryScreen> {
                scoped { FeatureASecondaryViewModel() } binds arrayOf(
                    ActionHandler::class,
                    StateHolder::class
                )
            }
        }
}
