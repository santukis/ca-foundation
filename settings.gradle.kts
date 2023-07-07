pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {
            from(files("gradle/configuration/dependencies/libs.versions.toml"))
        }
    }
}

rootProject.name = "ca-foundation"
include(":sample:app")
include(":sample:featureA")
include(":sample:featureB")
include(":sample:featureC")
include(":sample:featureD")

include(":domain")

include(":ui:navigation")
include(":ui:theme")


enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
