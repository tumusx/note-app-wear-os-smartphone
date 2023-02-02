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
include(":core:core-test")
include(":feature:feature-note-list")
include(":feature:feature-note")
include(":core:core-data")
include(":core:core-navigation")
include(":commons:common-design-system")
include(":commons:common-extensions")
