plugins {
    alias(libs.plugins.example.android.application)
    alias(libs.plugins.detekt)
    alias(libs.plugins.ktlint)
    id("androidx.navigation.safeargs.kotlin")
}

ktlint {
    verbose.set(true)
    android.set(true)
    outputToConsole.set(true)
}

buildscript {
    apply(from = "$rootDir/team-props/git-hooks.gradle.kts")
}

android {
    namespace = "com.example.clear_architecture_base.app.firstapp"

    defaultConfig {
        applicationId = "com.example.clear_architecture_base.firstapp"
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        dataBinding = true
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    flavorDimensions.add("default")

    productFlavors {
        create("develop") {
            applicationIdSuffix = ".test"
        }
        create("uat") {
            applicationIdSuffix = ".uat"
        }
        create("product") {
        }
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":shared"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.hilt.navigation.fragment)

    implementation(libs.paging.runtime)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.test)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
