package com.santukis.santukis.featureb.di

import com.santukis.injection.core.DependencyInjector
import com.santukis.injection.providers.koin.KoinDILibrary
import com.santukis.injection.providers.koin.KoinDIModule
import com.santukis.navigation.NavigationGraphStore
import com.santukis.santukis.featureb.FeatureBNavigationGraph

class FeatureBDILibrary : KoinDILibrary() {

    override fun getModules(): List<KoinDIModule> =
        listOf(
            FeatureBDIModule()
        )

    override fun populate(dependencyInjector: DependencyInjector) {
        with(dependencyInjector) {
            NavigationGraphStore::class.getDependency()?.addNavigationGraph(FeatureBNavigationGraph())
        }
    }
}
