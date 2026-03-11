pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("com.google.cloud.artifactregistry.gradle-plugin").version("2.2.5")
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        maven {
            url = uri("artifactregistry://europe-west1-maven.pkg.dev/staging-yomido/yomido-android")
//            credentials(HttpHeaderCredentials::class) {
//                name = "Authorization"
//                value = "Bearer ${getGcloudAccessToken()}"
//            }
//            authentication {
//                create<HttpHeaderAuthentication>("header")
//            }
        }
        mavenCentral()
    }
}

rootProject.name = "AndroidApp"
include(":app")