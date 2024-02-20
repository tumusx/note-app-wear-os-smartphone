plugins {
    id("com.android.application")
    kotlin("kapt")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "com.github.tumusx.wearos_app"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.percent.layout)
    implementation(libs.wearable)
    implementation(libs.wearOs)
    implementation(libs.legacy.lib)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.fragment.ui)
    kapt ("android.arch.persistence.room:compiler:1.1.1")
    implementation(project(mapOf("path" to ":core:testing")))
    implementation(project(mapOf("path" to ":feature:note-list")))
    implementation(project(mapOf("path" to ":feature:note")))
    implementation(project(mapOf("path" to ":core:navigation")))
}