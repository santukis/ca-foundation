plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply(from = "$rootDir/gradle/configuration/build/android_library_module.gradle")

android {
    namespace = "com.santukis.ca.components"
}

dependencies {
    implementation(libs.androidx.window)
    implementation(libs.androidx.window.core)
}
