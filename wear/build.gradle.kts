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

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("com.google.android.gms:play-services-wearable:18.0.0")
    implementation("androidx.percentlayout:percentlayout:1.0.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.wear:wear:1.2.0")
    implementation(project(mapOf("path" to ":common-test")))
    implementation(project(mapOf("path" to ":feature-note-list")))
    implementation(project(mapOf("path" to ":feature-note-create_update")))
    implementation(project(mapOf("path" to ":core-model")))
    implementation(project(mapOf("path" to ":core-database")))
}