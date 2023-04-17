@file:Suppress("UnstableApiUsage")
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
        maven {
            url = uri("https://artifactory-external.vkpartner.ru/artifactory/superappkit-maven-public/")
        }
        google()
        mavenCentral()


    }
}
rootProject.name = "Exernal SignIn api"
include(":app")
