buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.android.tools.build.gradle.plugin)
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.hilt.gradle.plugin)
    }
}

plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.example.android.application) apply false
    alias(libs.plugins.example.android.library) apply false
    alias(libs.plugins.example.android.test) apply false
    alias(libs.plugins.example.databinding) apply false
    alias(libs.plugins.example.dynamic) apply false
}