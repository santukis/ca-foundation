package com.santukis.sample.featurea.di

import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.StateHolder
import com.santukis.injection.providers.koin.KoinDIModule
import com.santukis.sample.featurea.landing.FeatureALandingScreen
import com.santukis.sample.featurea.landing.FeatureALandingState
import com.santukis.sample.featurea.landing.FeatureALandingViewModel
import com.santukis.sample.featurea.secondary.FeatureASecondaryScreen
import com.santukis.sample.featurea.secondary.FeatureASecondaryState
import com.santukis.sample.featurea.secondary.FeatureASecondaryViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

class FeatureADIModule : KoinDIModule() {

    override fun getModule(): Module =
        module {
            scope<FeatureALandingScreen> {
                viewModelOf(::FeatureALandingViewModel)

                scoped<StateHolder<FeatureALandingState>> {
                    get<FeatureALandingViewModel>()
                }

                scoped<ActionHandler> {
                    get<FeatureALandingViewModel>()
                }
            }

            scope<FeatureASecondaryScreen> {
                viewModelOf(::FeatureASecondaryViewModel)

                scoped<StateHolder<FeatureASecondaryState>> {
                    get<FeatureASecondaryViewModel>()
                }

                scoped<ActionHandler> {
                    get<FeatureASecondaryViewModel>()
                }
            }
        }
}
