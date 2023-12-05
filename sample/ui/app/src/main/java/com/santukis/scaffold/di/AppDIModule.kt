package com.santukis.scaffold.di

import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.StateHolder
import com.santukis.injection.providers.koin.KoinDIModule
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
import org.koin.dsl.binds
import org.koin.dsl.module

class AppDIModule : KoinDIModule() {

    override fun getModule(): Module =
        module {
            singleOf(::AppArgumentsMapper) bind ArgumentsMapper::class
            single { NavigationGraphStoreProvider.provide() }
            single<NavigationGraph> { get<NavigationGraphStore>() }

            scope<AppLandingScreen> {
                scoped { AppLandingViewModel() } binds arrayOf(
                    ActionHandler::class,
                    StateHolder::class
                )
            }
        }
}
