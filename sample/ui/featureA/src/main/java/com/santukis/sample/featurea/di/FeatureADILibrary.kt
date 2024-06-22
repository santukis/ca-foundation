package com.santukis.sample.featurea.di

import com.santukis.injection.core.DependencyInjector
import com.santukis.injection.koininjection.KoinDILibrary
import com.santukis.injection.koininjection.KoinDIModule
import com.santukis.navigation.NavigationGraphStore
import com.santukis.sample.featurea.FeatureANavigationGraph

class FeatureADILibrary : KoinDILibrary() {

    override fun getModules(): List<KoinDIModule> =
        listOf(
            FeatureADIModule()
        )

    override fun populate(dependencyInjector: DependencyInjector) {
        dependencyInjector.getDependency<NavigationGraphStore>(
            clazz = NavigationGraphStore::class
        ).addNavigationGraph(FeatureANavigationGraph())

    }
}
