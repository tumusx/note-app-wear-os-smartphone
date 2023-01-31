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
include(":wear-os")
include(":core-database")
include(":core-test")
include(":feature-note-list")
include(":feature-note")
include(":core-model")
include(":core-navigation")
include(":common-design-system")
include(":common-extensions")
