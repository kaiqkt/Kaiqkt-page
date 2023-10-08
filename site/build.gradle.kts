import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
}

group = "com.kaiqkt"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Powered by kaiqkt")
        }
    }
}

kotlin {
    configAsKobwebApplication("kaiqkt")

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk)
                implementation(libs.silk.icons.fa)
            }
        }
    }
}
