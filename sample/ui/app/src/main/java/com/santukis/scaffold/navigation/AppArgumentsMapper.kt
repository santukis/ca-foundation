package com.santukis.scaffold.navigation

import com.santukis.navigation.DestinationArgumentsMapper
import com.santukis.sample.featurea.navigation.arguments.FeatureAModel
import com.santukis.sample.featurec.navigation.arguments.FeatureCModel

class AppArgumentsMapper : DestinationArgumentsMapper {

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
