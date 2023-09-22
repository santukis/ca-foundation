package com.santukis.sample.featurec.di

import com.santukis.injection.providers.koin.KoinDILibrary
import com.santukis.injection.providers.koin.KoinDIModule
import com.santukis.navigation.NavigationGraphStore
import com.santukis.sample.featurec.FeatureCNavigationGraph
import org.koin.java.KoinJavaComponent

class FeatureCDILibrary : KoinDILibrary() {

    override fun getModules(): List<KoinDIModule> =
        listOf(
            FeatureCDIModule()
        )

    override fun populate() {
        val store: NavigationGraphStore = KoinJavaComponent.getKoin().get()
        store.addNavigationGraph(FeatureCNavigationGraph())
    }
}
