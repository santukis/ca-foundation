package com.santukis.sample.featurec.di

import com.santukis.injection.core.DependencyInjector
import com.santukis.injection.providers.koin.KoinDILibrary
import com.santukis.injection.providers.koin.KoinDIModule
import com.santukis.navigation.NavigationGraphStore
import com.santukis.sample.featurec.FeatureCNavigationGraph

class FeatureCDILibrary : KoinDILibrary() {

    override fun getModules(): List<KoinDIModule> =
        listOf(
            FeatureCDIModule()
        )

    override fun populate(dependencyInjector: DependencyInjector) {
        with(dependencyInjector) {
            NavigationGraphStore::class.getDependency()?.addNavigationGraph(FeatureCNavigationGraph())
        }
    }
}
