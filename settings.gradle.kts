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
            from(files("gradle/libs.version.toml"))
        }
    }
}
rootProject.name = "Notas Mágicas"
include(":smartphone")
include(":wear-os")
include(":core:testing")
include(":feature:note-list")
include(":feature:note")
include(":core:navigation")
include(":commons:design-system")
include(":commons:extensions")
include(":core:database")
include(":core:model")
