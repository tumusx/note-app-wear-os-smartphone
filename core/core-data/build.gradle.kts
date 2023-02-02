plugins {
    id("com.android.library")
    kotlin("kapt")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 23
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    androidTestImplementation(libs.junit.android.core)
    androidTestImplementation(libs.junit.android)
    testImplementation(libs.junit)
    implementation(project(mapOf("path" to ":feature:feature-note-list")))
    implementation(project(mapOf("path" to ":feature:feature-note")))
}