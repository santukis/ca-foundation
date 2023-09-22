plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
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
    implementation(projects.ui.navigation)
    implementation(projects.ui.components)
    implementation(projects.ui.theme)

    implementation(projects.sample.ui.featureA)
    implementation(projects.sample.ui.featureB)
    implementation(projects.sample.ui.featureC)
    implementation(projects.sample.ui.featureD)
}
