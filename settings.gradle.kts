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

include(":domain")

include(":data:repository")
include(":data:datasource:remote")
include(":data:datasource:local")

include(":ui:navigation")
include(":ui:theme")
include(":ui:components")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
