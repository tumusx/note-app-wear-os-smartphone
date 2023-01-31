plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.github.tumusx.wearos_app"
        minSdk = 26
        targetSdk = 32
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
    implementation(project(mapOf("path" to ":core-test")))
    implementation(project(mapOf("path" to ":feature-note-list")))
    implementation(project(mapOf("path" to ":feature-note")))
    implementation(project(mapOf("path" to ":core-model")))
    implementation(project(mapOf("path" to ":core-database")))
    implementation(project(mapOf("path" to ":core-navigation")))
}