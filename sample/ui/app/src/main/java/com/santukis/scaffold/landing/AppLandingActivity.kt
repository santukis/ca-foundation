package com.santukis.scaffold.landing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.santukis.theme.ScaffoldTheme

class AppLandingActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ScaffoldTheme {
                AppLandingScreen().Layout()
            }
        }
    }
}
