package com.santukis.injection.koininjection

import com.santukis.ca.components.scaffold.CaViewModel
import com.santukis.ca.components.scaffold.ScreenState
import com.santukis.ca.components.scaffold.UiState
import com.santukis.injection.core.DIModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.module.dsl.DefinitionOptions
import org.koin.core.module.dsl.new
import org.koin.core.module.dsl.onOptions
import org.koin.dsl.ScopeDSL

abstract class KoinDIModule : DIModule<Module> {

    inline fun <reified S : ScreenState, reified US : UiState> ScopeDSL.caViewModelOf(
        crossinline constructor: () -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1> ScopeDSL.caViewModelOf(
        crossinline constructor: (T1) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2> ScopeDSL.caViewModelOf(
        crossinline constructor: (T1, T2) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3> ScopeDSL.caViewModelOf(
        crossinline constructor: (T1, T2, T3) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3, reified T4> ScopeDSL.caViewModelOf(
        crossinline constructor: (T1, T2, T3, T4) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3, reified T4, reified T5> ScopeDSL.caViewModelOf(
        crossinline constructor: (T1, T2, T3, T4, T5) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6> ScopeDSL.caViewModelOf(
        crossinline constructor: (T1, T2, T3, T4, T5, T6) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7> ScopeDSL.caViewModelOf(
        crossinline constructor: (T1, T2, T3, T4, T5, T6, T7) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8> ScopeDSL.caViewModelOf(
        crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9> ScopeDSL.caViewModelOf(
        crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10> ScopeDSL.caViewModelOf(
        crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11> ScopeDSL.caViewModelOf(
        crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12> ScopeDSL.caViewModelOf(
        crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13> ScopeDSL.caViewModelOf(
        crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14> ScopeDSL.caViewModelOf(
        crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15> ScopeDSL.caViewModelOf(
        crossinline constructor:
        (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16> ScopeDSL.caViewModelOf(
        crossinline constructor:
        (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17> ScopeDSL.caViewModelOf(
        crossinline constructor:
        (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18> ScopeDSL.caViewModelOf(
        crossinline constructor:
        (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19> ScopeDSL.caViewModelOf(
        crossinline constructor:
        (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20> ScopeDSL.caViewModelOf(
        crossinline constructor: (
            T1,
            T2,
            T3,
            T4,
            T5,
            T6,
            T7,
            T8,
            T9,
            T10,
            T11,
            T12,
            T13,
            T14,
            T15,
            T16,
            T17,
            T18,
            T19,
            T20
        ) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20, reified T21> ScopeDSL.caViewModelOf(
        crossinline constructor: (
            T1,
            T2,
            T3,
            T4,
            T5,
            T6,
            T7,
            T8,
            T9,
            T10,
            T11,
            T12,
            T13,
            T14,
            T15,
            T16,
            T17,
            T18,
            T19,
            T20,
            T21
        ) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)

    inline fun <reified S : ScreenState, reified US : UiState, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20, reified T21, reified T22> ScopeDSL.caViewModelOf(
        crossinline constructor: (
            T1,
            T2,
            T3,
            T4,
            T5,
            T6,
            T7,
            T8,
            T9,
            T10,
            T11,
            T12,
            T13,
            T14,
            T15,
            T16,
            T17,
            T18,
            T19,
            T20,
            T21,
            T22
        ) -> CaViewModel<S, US>,
        noinline options: DefinitionOptions<CaViewModel<S, US>>? = {
            qualifier = scopeQualifier
        },
    ): KoinDefinition<CaViewModel<S, US>> = viewModel { new(constructor) }.onOptions(options)
}
