package com.santukis.sample.featured.di

import com.santukis.ca.ui.navigation.NavigationGraphStore
import com.santukis.injection.core.DependencyInjector
import com.santukis.injection.koininjection.KoinDILibrary
import com.santukis.injection.koininjection.KoinDIModule
import com.santukis.sample.featured.FeatureDNavigationGraph

class FeatureDDILibrary : KoinDILibrary() {

    override fun getModules(): List<KoinDIModule> =
        listOf(
            FeatureDDIModule()
        )

    override fun populate(dependencyInjector: DependencyInjector) {
        dependencyInjector.getDependency<NavigationGraphStore>(
            clazz = NavigationGraphStore::class
        ).addNavigationGraph(FeatureDNavigationGraph())
    }
}
