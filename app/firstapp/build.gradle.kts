plugins {
    alias(libs.plugins.example.android.application)
    alias(libs.plugins.detekt)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.kotlinx.kover)
    id("androidx.navigation.safeargs.kotlin")
}

ktlint {
    verbose.set(true)
    android.set(true)
    outputToConsole.set(true)
}

kover {
    reports {
        // filters for all report types of all build variants
        filters.excludes.androidGeneratedClasses()

        variant("developDebug") {
            // verification only for 'release' build variant
            verify.rule {
                minBound(50)
            }

            // filters for all report types only for 'release' build variant
            filters.excludes {
                androidGeneratedClasses()
                classes(
                    // excludes debug classes
                    "*.DebugUtil"
                )
            }
        }
    }
}

tasks.withType<Test> {
    // useJUnitPlatform() // Optional, depending on the testing framework you are using
    finalizedBy("koverHtmlReport") // Generate the HTML report after tests run
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
        getByName("debug") {
            enableAndroidTestCoverage = true
        }
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
    testImplementation(libs.androidx.core.testing)
    testImplementation(libs.androidx.test.core)
    testImplementation(libs.mockk)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
