import java.util.Properties

plugins {
    id("com.android.application")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.github.tumusx.masternote"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.github.tumusx.masternote"
        minSdk = 23
        targetSdk = 33
        versionCode = 11
        versionName = "1.1"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = ("1.8")
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.fragment.ui)
    implementation(libs.dagger.android)
    val room = "2.3.0"
    implementation ("androidx.room:room-runtime:$room")
    implementation ("androidx.room:room-ktx:$room")
    kapt ("androidx.room:room-compiler:$room")
    kapt(libs.dagger.compiler)
    implementation(project(mapOf("path" to ":core:testing")))
    implementation(project(mapOf("path" to ":feature:note-list")))
    implementation(project(mapOf("path" to ":feature:note")))
    implementation(project(mapOf("path" to ":core:navigation")))
}