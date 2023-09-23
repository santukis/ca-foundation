package com.santukis.sample.featurea.di

import com.santukis.injection.core.DependencyInjector
import com.santukis.injection.providers.koin.KoinDILibrary
import com.santukis.injection.providers.koin.KoinDIModule
import com.santukis.navigation.NavigationGraphStore
import com.santukis.sample.featurea.FeatureANavigationGraph

class FeatureADILibrary : KoinDILibrary() {

    override fun getModules(): List<KoinDIModule> =
        listOf(
            FeatureADIModule()
        )

    override fun populate(dependencyInjector: DependencyInjector) {
        with(dependencyInjector) {
            NavigationGraphStore::class.getDependency()?.addNavigationGraph(FeatureANavigationGraph())
        }
    }
}
