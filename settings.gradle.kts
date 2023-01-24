pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
enableFeaturePreview("VERSION_CATALOGS")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("$rootDir/libs.version.toml"))
        }
    }
}
rootProject.name = "Master Note"
include(":smartphone")
include(":wear")
include(":core-database")
include(":common-test")
include(":feature-note-list")
include(":feature-note-create_update")
include(":core-model")
include(":core-navigation")
