package com.santukis.scaffold

import com.santukis.ca.ui.navigation.ArgumentsMapper
import com.santukis.sample.featurea.landing.navigation.FeatureAModel
import com.santukis.sample.featurec.landing.navigation.FeatureCModel

class AppArgumentsMapper : ArgumentsMapper {

    override fun <Result : Any> map(from: Result): Any =
        when (from) {
            is FeatureCModel ->
                FeatureAModel(
                    field1 = from.field1,
                    field2 = from.field2,
                    field3 = from.field3
                )
            else -> from
        }
}
