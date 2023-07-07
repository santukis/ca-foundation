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
    implementation(projects.ui.navigation)
    implementation(projects.ui.theme)

    implementation(projects.sample.featureA)
    implementation(projects.sample.featureB)
    implementation(projects.sample.featureC)
    implementation(projects.sample.featureD)
}
