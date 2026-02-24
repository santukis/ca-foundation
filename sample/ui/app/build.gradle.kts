plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.compose.compiler)
}

apply(from = "$rootDir/gradle/configuration/build/android_module.gradle")

android {
    namespace = "com.santukis.scaffold"

    defaultConfig {
        applicationId = "com.santukis.scaffold"
    }
}

dependencies {
    implementation(projects.injection.core)
    implementation(projects.injection.koinProvider)
    implementation(projects.ui)

    implementation(projects.sample.ui.featureA)
    implementation(projects.sample.ui.featureB)
    implementation(projects.sample.ui.featureC)
    implementation(projects.sample.ui.featureD)
}
