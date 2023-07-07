package com.santukis.sample.featured.navitation.destinations

import android.app.Activity
import com.santukis.navigation.ActivityDestination
import com.santukis.sample.featured.FeatureDActivity
import kotlin.reflect.KClass

object FeatureDLandingDestination : ActivityDestination {

    private const val ANY_PARAM_KEY = "anyParam"

    override val template: String = "featureD/landing/{$ANY_PARAM_KEY}"

    override fun getActivityDestination(): KClass<out Activity>? =
        FeatureDActivity::class
}
