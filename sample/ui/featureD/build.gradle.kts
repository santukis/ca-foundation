plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.compose.compiler)
}

apply(from = "$rootDir/gradle/configuration/build/android_module.gradle")

android {
    namespace = "com.santukis.sample.featured"
}

dependencies {
    implementation(projects.injection)
    implementation(projects.ui)
}
