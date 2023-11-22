package com.santukis.scaffold.di

import com.santukis.ca.components.scaffold.ActionHandler
import com.santukis.ca.components.scaffold.StateHolder
import com.santukis.injection.providers.koin.KoinDIModule
import com.santukis.navigation.ArgumentsMapper
import com.santukis.navigation.NavigationGraph
import com.santukis.navigation.NavigationGraphStore
import com.santukis.navigation.NavigationGraphStoreProvider
import com.santukis.navigation.RouterProvider
import com.santukis.scaffold.AppArgumentsMapper
import com.santukis.scaffold.landing.AppLandingAction
import com.santukis.scaffold.landing.AppLandingScreen
import com.santukis.scaffold.landing.AppLandingState
import com.santukis.scaffold.landing.AppLandingViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.TypeQualifier
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

class AppDIModule : KoinDIModule() {

    override fun getModule(): Module =
        module {
            singleOf(::AppArgumentsMapper) bind ArgumentsMapper::class
            single { RouterProvider.provide(get(), get()) }
            single { NavigationGraphStoreProvider.provide() }
            single<NavigationGraph> { get<NavigationGraphStore>() }

            viewModelOf(::AppLandingViewModel)
            factory<StateHolder<AppLandingState>>(TypeQualifier(AppLandingScreen::class)) {
                get<AppLandingViewModel>()
            }
            factory<ActionHandler>(TypeQualifier(AppLandingScreen::class)) {
                get<AppLandingViewModel>()
            }
        }
}
