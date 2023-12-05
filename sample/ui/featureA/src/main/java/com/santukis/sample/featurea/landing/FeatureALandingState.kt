package com.santukis.sample.featurea.landing

import com.santukis.ca.components.scaffold.ScreenState

class FeatureALandingState(
    val field01: String = "",
    val field02: Int = 0,
    val field03: Boolean = false,
    val field04: List<String> = listOf(),
    val field05: LandingItem? = null,
    val field06: FeatureALandingItem? = ItemA()
) : ScreenState {

    class LandingItem(
        val field01: String = "",
        val field02: Long = 0L
    )

    @Suppress("LongParameterList")
    fun copy(
        field01: String = this.field01,
        field02: Int = this.field02,
        field03: Boolean = this.field03,
        field04: List<String> = this.field04,
        field05: LandingItem? = this.field05,
        field06: FeatureALandingItem? = this.field06
    ): FeatureALandingState =
        FeatureALandingState(
            field01 = field01,
            field02 = field02,
            field03 = field03,
            field04 = field04,
            field05 = field05,
            field06 = field06
        )
}

interface FeatureALandingItem

class ItemA : FeatureALandingItem

class ItemB : FeatureALandingItem
