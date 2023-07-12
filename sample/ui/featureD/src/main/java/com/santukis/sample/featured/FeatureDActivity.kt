package com.santukis.sample.featured

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.santukis.sample.featured.navitation.arguments.ToFeatureAResultArguments
import com.santukis.sample.featured.screens.FeatureDLandingScreen
import com.santukis.theme.ScaffoldTheme

class FeatureDActivity : ComponentActivity() {

    companion object {
        const val ANY_PARAM_KEY = "anyParam"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ScaffoldTheme {
                FeatureDLandingScreen(
                    anyParam = intent.getStringExtra(ANY_PARAM_KEY).orEmpty(),
                    navigateTo = { arguments ->
                        when (arguments) {
                            is ToFeatureAResultArguments -> {
                                finish()
                            }
                        }
                    }
                )
            }
        }
    }
}
