package com.santukis.santukis.featureb.di

import com.santukis.injection.providers.koin.KoinDILibrary
import com.santukis.injection.providers.koin.KoinDIModule
import com.santukis.navigation.NavigationGraphStore
import com.santukis.santukis.featureb.FeatureBNavigationGraph
import org.koin.java.KoinJavaComponent

class FeatureBDILibrary : KoinDILibrary() {

    override fun getModules(): List<KoinDIModule> =
        listOf(
            FeatureBDIModule()
        )

    override fun populate() {
        val store: NavigationGraphStore = KoinJavaComponent.getKoin().get()
        store.addNavigationGraph(FeatureBNavigationGraph())
    }
}
