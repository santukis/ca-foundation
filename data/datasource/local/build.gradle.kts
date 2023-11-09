plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

apply(from = "$rootDir/gradle/configuration/build/android_library_module.gradle")

android {
    namespace = "com.santukis.ca.data.datasource.local"
}

dependencies {
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
}
