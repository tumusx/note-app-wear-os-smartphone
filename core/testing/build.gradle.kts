plugins {
    id("com.android.library")
    kotlin("kapt")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 33

    defaultConfig {
        minSdk = 23
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(libs.junit.android.core)
    implementation(libs.junit.android)
    implementation(libs.junit)
    implementation(libs.android.test.core)
    implementation("androidx.lifecycle:lifecycle-livedata-core-ktx:2.5.1")
}