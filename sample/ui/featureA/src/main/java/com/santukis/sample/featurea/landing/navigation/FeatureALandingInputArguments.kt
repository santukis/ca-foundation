package com.santukis.sample.featurea.landing.navigation

import android.os.Bundle
import com.santukis.ca.ui.navigation.InputArguments

class FeatureALandingInputArguments: InputArguments.ArgumentKey<Bundle, String> {

    override fun getValue(arguments: Bundle?): String? =
        arguments?.getString(FeatureALandingDestinationTemplate.FEATURE_D_RESULT)
}
