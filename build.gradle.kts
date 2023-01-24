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
    }
}


tasks.register(name = "type", type = Delete::class) {
    delete(rootProject.buildDir)
}