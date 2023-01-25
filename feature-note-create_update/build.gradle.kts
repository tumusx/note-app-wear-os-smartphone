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
      implementation(libs.androidx.core.ktx)
      implementation(libs.appcompat)
      implementation(libs.material)
      implementation(libs.constraintlayout)
      androidTestImplementation(libs.junit.android.core)
      androidTestImplementation(libs.junit.android)
      testImplementation(libs.junit)
      implementation(libs.navigation.fragment.ktx)
      implementation(libs.navigation.fragment.ui)
  }