import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.github.tumusx.masternote"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.github.tumusx.masternote"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    implementation(project(mapOf("path" to ":core:core-test")))
    implementation(project(mapOf("path" to ":feature:feature-note-list")))
    implementation(project(mapOf("path" to ":feature:feature-note")))
    implementation(project(mapOf("path" to ":core:core-data")))
    implementation(project(mapOf("path" to ":core:core-navigation")))
}