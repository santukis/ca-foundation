package com.santukis.sample.featured.landing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.santukis.navigation.Router
import com.santukis.sample.featured.landing.FeatureDLandingNavigationAction.NavigateToFeatureAScreen
import com.santukis.sample.featured.landing.views.FeatureDLandingInputArguments
import com.santukis.theme.ScaffoldTheme
import org.koin.compose.koinInject

class FeatureDLandingActivity : ComponentActivity() {

    companion object {
        const val ANY_PARAM_KEY = "anyParam"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ScaffoldTheme {
                val router: Router = koinInject()

                FeatureDLandingScreen().Layout(
                    arguments = FeatureDLandingInputArguments(
                        intent.getStringExtra(ANY_PARAM_KEY).orEmpty()
                    )
                ) { action ->
                    when (action) {
                        is NavigateToFeatureAScreen -> {
                            router.navigate(action.arguments) {
                                launchSingleTop = true
                            }
                            finish()
                        }
                    }
                }
            }
        }
    }
}
