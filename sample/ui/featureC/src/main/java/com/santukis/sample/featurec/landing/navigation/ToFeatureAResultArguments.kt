package com.santukis.sample.featurec.landing.navigation

import android.os.Parcelable
import com.santukis.navigation.ResultArguments
import kotlinx.parcelize.Parcelize

class ToFeatureAResultArguments(
    override val result: FeatureCModel
) : ResultArguments<FeatureCModel>

@Parcelize
data class FeatureCModel(
    val field1: String = "",
    val field2: String = "",
    val field3: String = ""
) : Parcelable
