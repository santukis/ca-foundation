package com.santukis.santukis.featureb.landing.navigation

import android.os.Bundle
import com.santukis.navigation.InputArguments

class FeatureBSecondaryInputArguments:
    InputArguments.ArgumentKey<Bundle, String> {

    override fun getValue(arguments: Bundle?): String? = null
}
