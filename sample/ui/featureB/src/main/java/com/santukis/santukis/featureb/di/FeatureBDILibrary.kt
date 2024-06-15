package com.santukis.santukis.featureb.di

import com.santukis.injection.core.DependencyInjector
import com.santukis.injection.koininjection.KoinDILibrary
import com.santukis.injection.koininjection.KoinDIModule
import com.santukis.navigation.NavigationGraphStore
import com.santukis.santukis.featureb.FeatureBNavigationGraph

class FeatureBDILibrary : KoinDILibrary() {

    override fun getModules(): List<KoinDIModule> =
        listOf(
            FeatureBDIModule()
        )

    override fun populate(dependencyInjector: DependencyInjector) {
        dependencyInjector.getDependency<NavigationGraphStore>(
            clazz = NavigationGraphStore::class
        )?.addNavigationGraph(FeatureBNavigationGraph())
    }
}
