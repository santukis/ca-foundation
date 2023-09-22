package com.santukis.sample.featured.landing

import android.app.Activity
import com.santukis.navigation.ActivityDestination
import kotlin.reflect.KClass

object FeatureDLandingDestination : ActivityDestination {

    private const val ANY_PARAM_KEY = "anyParam"

    override val template: String = "featureD/landing/{$ANY_PARAM_KEY}"

    override fun getActivityDestination(): KClass<out Activity>? =
        FeatureDLandingActivity::class
}
