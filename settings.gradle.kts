import org.gradle.kotlin.dsl.maven
import org.gradle.api.credentials.PasswordCredentials

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

//        maven {
//            name = "GitHubPackages"
//            url = uri("https://maven.pkg.github.com/dmytro-ipatii-aalto/KMPSharedLibrary")
//            credentials(PasswordCredentials::class)
////            credentials {
////                username = providers.gradleProperty("githubPackagesUsername")
////                    .orElse(providers.environmentVariable("USER_NAME"))
////                    .get()
////
////                password = providers.gradleProperty("githubPackagesPassword")
////                    .orElse(providers.environmentVariable("DEV_ACCESS_TOKEN"))
////                    .get()
////            }
//        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        //mavenLocal()
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/dmytro-ipatii-aalto/KMPSharedLibrary")
            credentials(PasswordCredentials::class)
        }
    }
}

rootProject.name = "AndroidApp"
include(":app")
 