buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
        classpath("com.github.triplet.gradle:play-publisher:4.0.0-SNAPSHOT")
        classpath(libs.navigation.safe.args)
        classpath("org.junit.jupiter:junit-jupiter-api:5.9.2")
    }
}

plugins{
    id("com.google.dagger.hilt.android") version "2.44" apply false
    kotlin("jvm") version "1.8.10"
    kotlin("plugin.serialization") version "1.8.10"
}


tasks.register(name = "type", type = Delete::class) {
    delete(rootProject.buildDir)
}