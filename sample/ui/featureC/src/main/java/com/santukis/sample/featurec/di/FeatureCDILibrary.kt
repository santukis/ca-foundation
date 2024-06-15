package com.santukis.sample.featurec.di

import com.santukis.injection.core.DependencyInjector
import com.santukis.injection.koininjection.KoinDILibrary
import com.santukis.injection.koininjection.KoinDIModule
import com.santukis.navigation.NavigationGraphStore
import com.santukis.sample.featurec.FeatureCNavigationGraph

class FeatureCDILibrary : KoinDILibrary() {

    override fun getModules(): List<KoinDIModule> =
        listOf(
            FeatureCDIModule()
        )

    override fun populate(dependencyInjector: DependencyInjector) {
        dependencyInjector.getDependency<NavigationGraphStore>(
            clazz = NavigationGraphStore::class
        )?.addNavigationGraph(FeatureCNavigationGraph())
    }
}
