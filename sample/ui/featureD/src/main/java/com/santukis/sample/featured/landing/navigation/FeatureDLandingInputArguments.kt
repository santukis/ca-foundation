package com.santukis.sample.featured.landing.navigation

import android.content.Intent
import com.santukis.navigation.InputArguments
import com.santukis.sample.featured.host.FeatureDActivity

class FeatureDLandingInputArguments: InputArguments.ArgumentKey<Intent, String> {

    override fun getValue(arguments: Intent?): String? =
        arguments?.getStringExtra(FeatureDActivity.ANY_PARAM_KEY)
}
