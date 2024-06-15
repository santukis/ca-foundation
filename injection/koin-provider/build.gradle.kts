plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply(from = "$rootDir/gradle/configuration/build/android_library_module.gradle")

android {
    namespace = "com.santukis.injection.koin.provider"
}

dependencies {
    implementation(projects.injection.core)
    implementation(projects.ui.components)
}
