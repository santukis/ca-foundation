package com.santukis.sample.featured.di

import com.santukis.injection.providers.koin.KoinDILibrary
import com.santukis.injection.providers.koin.KoinDIModule
import com.santukis.navigation.NavigationGraphStore
import com.santukis.sample.featured.FeatureDNavigationGraph
import org.koin.java.KoinJavaComponent

class FeatureDDILibrary : KoinDILibrary() {

    override fun getModules(): List<KoinDIModule> =
        listOf(
            FeatureDDIModule()
        )

    override fun populate() {
        val store: NavigationGraphStore = KoinJavaComponent.getKoin().get()
        store.addNavigationGraph(FeatureDNavigationGraph())
    }
}
