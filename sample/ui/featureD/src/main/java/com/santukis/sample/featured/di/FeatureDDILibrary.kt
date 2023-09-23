package com.santukis.sample.featured.di

import com.santukis.injection.core.DependencyInjector
import com.santukis.injection.providers.koin.KoinDILibrary
import com.santukis.injection.providers.koin.KoinDIModule
import com.santukis.navigation.NavigationGraphStore
import com.santukis.sample.featured.FeatureDNavigationGraph

class FeatureDDILibrary : KoinDILibrary() {

    override fun getModules(): List<KoinDIModule> =
        listOf(
            FeatureDDIModule()
        )

    override fun populate(dependencyInjector: DependencyInjector) {
        with(dependencyInjector) {
            NavigationGraphStore::class.getDependency()?.addNavigationGraph(FeatureDNavigationGraph())
        }
    }
}
