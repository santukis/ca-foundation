plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.compose.compiler)
}

apply(from = "$rootDir/gradle/configuration/build/android_library_module.gradle")

android {
    namespace = "com.santukis.ca.ui"
}

dependencies {
    implementation(libs.androidx.window)
    implementation(libs.androidx.window.core)
    implementation(projects.injection)
}
