plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.compose.compiler)
}

apply(from = "$rootDir/gradle/configuration/build/android_module.gradle")

android {
    namespace = "com.santukis.santukis.featureb"
}

dependencies {
    implementation(projects.injection.core)
    implementation(projects.injection.koinProvider)
    implementation(projects.ui.components)
    implementation(projects.ui.navigation)
    implementation(projects.ui.theme)
}
