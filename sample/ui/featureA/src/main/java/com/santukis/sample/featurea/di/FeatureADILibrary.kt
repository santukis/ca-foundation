package com.santukis.sample.featurea.di

import com.santukis.injection.providers.koin.KoinDILibrary
import com.santukis.injection.providers.koin.KoinDIModule
import com.santukis.navigation.NavigationGraphStore
import com.santukis.sample.featurea.FeatureANavigationGraph
import org.koin.java.KoinJavaComponent

class FeatureADILibrary : KoinDILibrary() {

    override fun getModules(): List<KoinDIModule> =
        listOf(
            FeatureADIModule()
        )

    override fun populate() {
        val store: NavigationGraphStore = KoinJavaComponent.getKoin().get()
        store.addNavigationGraph(FeatureANavigationGraph())
    }
}
