package com.santukis.sample.featurea.navigation.arguments

import android.os.Parcelable
import com.santukis.navigation.DestinationArgumentsForResult
import kotlinx.parcelize.Parcelize

class ToFeatureCArguments(
    private val anyParam: String,
    override val onResult: (FeatureAModel) -> Unit
) : DestinationArgumentsForResult<FeatureAModel> {

    override fun getRoute(): String = "featureC/landing/$anyParam"
}

@Parcelize
data class FeatureAModel(
    val field1: String = "",
    val field2: String = "",
    val field3: String = ""
) : Parcelable
