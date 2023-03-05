plugins {
    id("com.android.library")
    kotlin("kapt")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id ("androidx.navigation.safeargs.kotlin")
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(project(mapOf("path" to ":core:database")))
    testImplementation(project(mapOf("path" to ":core:testing")))
    androidTestImplementation(libs.junit.android.core)
    androidTestImplementation(libs.junit.android)
    testImplementation(libs.junit)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.fragment.ui)
    implementation(libs.dagger.android)
    implementation(libs.testCoroutines)
    kapt(libs.dagger.compiler)
    val room = "2.3.0"
    implementation ("androidx.room:room-runtime:$room")
    implementation ("androidx.room:room-ktx:$room")
    kapt ("androidx.room:room-compiler:$room")
    implementation(project(mapOf("path" to ":core:navigation")))
    implementation(project(mapOf("path" to ":commons:design-system")))
    implementation(project(mapOf("path" to ":core:model")))
}