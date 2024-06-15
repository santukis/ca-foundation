plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
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
