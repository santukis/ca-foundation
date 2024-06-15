package com.santukis.scaffold.di

import com.santukis.injection.koininjection.KoinDIGraph
import com.santukis.injection.koininjection.KoinDILibrary
import com.santukis.sample.featurea.di.FeatureADILibrary
import com.santukis.sample.featurec.di.FeatureCDILibrary
import com.santukis.sample.featured.di.FeatureDDILibrary
import com.santukis.santukis.featureb.di.FeatureBDILibrary

class AppDIGraph : com.santukis.injection.koininjection.KoinDIGraph() {

    override fun getLibraries(): List<com.santukis.injection.koininjection.KoinDILibrary> =
        listOf(
            AppDILibrary(),
            FeatureADILibrary(),
            FeatureBDILibrary(),
            FeatureCDILibrary(),
            FeatureDDILibrary()
        )
}
