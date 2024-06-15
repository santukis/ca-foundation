package com.santukis.scaffold.di

import com.santukis.ca.components.scaffold.CaViewModel
import com.santukis.injection.koininjection.KoinDIModule
import com.santukis.navigation.ArgumentsMapper
import com.santukis.navigation.NavigationGraph
import com.santukis.navigation.NavigationGraphStore
import com.santukis.navigation.NavigationGraphStoreProvider
import com.santukis.scaffold.AppArgumentsMapper
import com.santukis.scaffold.landing.AppLandingScreen
import com.santukis.scaffold.landing.AppLandingViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

class AppDIModule : KoinDIModule() {

    override fun getModule(): Module =
        module {
            singleOf(::AppArgumentsMapper) bind ArgumentsMapper::class
            single { NavigationGraphStoreProvider.provide() }
            single<NavigationGraph> { get<NavigationGraphStore>() }

            scope<AppLandingScreen> {
                caViewModelOf(::AppLandingViewModel) bind CaViewModel::class
            }
        }
}
