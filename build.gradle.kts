buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.android.tools.build.gradle.plugin)
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.hilt.gradle.plugin)
        classpath(libs.androidx.navigation.safe.args.gradle.plugin)
    }
}

plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.example.android.application) apply false
    alias(libs.plugins.example.android.library) apply false
    alias(libs.plugins.example.android.test) apply false
    alias(libs.plugins.example.dynamic) apply false
    alias(libs.plugins.kotlinx.kover) apply false

    alias(libs.plugins.detekt)
    alias(libs.plugins.ktlint)
}

detekt {
    toolVersion = "1.23.6"

    source.setFrom(
        files(
            "app/firstapp/src/main/java",
            "app/secondapp/src/main/java",
            "core/src/main/java"
        )
    )
    parallel = false
    config.setFrom(files("$rootDir/detekt-config.yml"))
    buildUponDefaultConfig = false
    disableDefaultRuleSets = false

    debug = false
    ignoreFailures = false

    ignoredBuildTypes = listOf("release")
    ignoredFlavors = listOf("production")
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    jvmTarget = JavaVersion.VERSION_17.toString()
    reports {
        xml {
            outputLocation.set(file("build/reports/detekt/detekt.xml"))
        }
        html {
            outputLocation.set(file("build/reports/detekt/detekt.html"))
        }
    }
}
