package com.santukis.santukis.featureb.di

import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.StateHolder
import com.santukis.injection.providers.koin.KoinDIModule
import com.santukis.santukis.featureb.landing.FeatureBLandingScreen
import com.santukis.santukis.featureb.landing.FeatureBLandingViewModel
import com.santukis.santukis.featureb.secondary.FeatureBSecondaryScreen
import com.santukis.santukis.featureb.secondary.FeatureBSecondaryViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.binds
import org.koin.dsl.module

class FeatureBDIModule : KoinDIModule() {

    override fun getModule(): Module =
        module {
            scope<FeatureBLandingScreen> {
                viewModelOf(::FeatureBLandingViewModel) binds arrayOf(
                    ActionHandler::class,
                    StateHolder::class
                )
            }

            scope<FeatureBSecondaryScreen> {
                viewModelOf(::FeatureBSecondaryViewModel) binds arrayOf(
                    ActionHandler::class,
                    StateHolder::class
                )
            }
        }
}
