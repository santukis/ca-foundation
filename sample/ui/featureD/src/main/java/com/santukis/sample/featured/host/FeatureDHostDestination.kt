package com.santukis.sample.featured.host

import android.app.Activity
import com.santukis.ca.ui.navigation.ActivityDestination
import com.santukis.ca.ui.navigation.DestinationTemplate
import com.santukis.sample.featured.host.navigation.FeatureDHostDestinationTemplate
import kotlin.reflect.KClass

class FeatureDHostDestination : ActivityDestination {

    override val template: DestinationTemplate = FeatureDHostDestinationTemplate()

    override fun getActivityDestination(): KClass<out Activity> = FeatureDActivity::class
}
