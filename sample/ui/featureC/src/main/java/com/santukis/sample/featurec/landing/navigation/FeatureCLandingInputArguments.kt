package com.santukis.sample.featurec.landing.navigation

import android.os.Bundle
import com.santukis.navigation.InputArguments

class FeatureCLandingInputArguments: InputArguments.ArgumentKey<Bundle, String> {

    override fun getValue(arguments: Bundle?): String? =
        arguments?.getString(FeatureCLandingDestinationTemplate.ANY_PARAM_KEY)
}
