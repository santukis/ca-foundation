plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

apply(from = "$rootDir/gradle/configuration/build/android_module.gradle")

android {
    namespace = "com.santukis.ca.data.datasource.local"
}

dependencies {
    implementation(projects.data.repository)
    implementation(libs.androidx.room.runtime)
    implementation(libs.squareup.moshi)
    implementation(libs.squareup.moshi.kotlin)
    ksp(libs.androidx.room.compiler)
}
