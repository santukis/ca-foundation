plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
}

apply(from = "$rootDir/gradle/configuration/build/android_library_module.gradle")

android {
    namespace = "com.santukis.ca.data"
}

dependencies {
    implementation(projects.domain)
    implementation(libs.androidx.room.runtime)
    implementation(libs.squareup.moshi)
    implementation(libs.squareup.moshi.kotlin)
    ksp(libs.androidx.room.compiler)
    implementation(libs.bundles.retrofit)
    implementation(libs.kotlin.coroutines.core)
    ksp(libs.squareup.moshi.codegen)
}
