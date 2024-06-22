package com.santukis.sample.featured.host

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.santukis.navigation.ScreenArguments
import com.santukis.theme.ScaffoldTheme

class FeatureDActivity : ComponentActivity() {

    companion object {
        const val ANY_PARAM_KEY = "anyParam"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ScaffoldTheme {

                FeatureDHostScreen().Layout(
                    arguments = ScreenArguments(arguments = intent)
                )
            }
        }
    }
}
