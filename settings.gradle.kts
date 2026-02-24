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

include(":sample:ui:app")
include(":sample:ui:featureA")
include(":sample:ui:featureB")
include(":sample:ui:featureC")
include(":sample:ui:featureD")

include(":injection:core")
include(":injection:koin-provider")

include(":domain")
include(":data")
include(":ui")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
