plugins {
    alias(libs.plugins.example.android.library)
    alias(libs.plugins.detekt)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.kotlinx.kover)
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
                minBound(10)
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

android {
    namespace = "com.example.clear_architecture_base.domain"

    // To avoid warning for modules which they have no flavor
    flavorDimensions.add("default")
    productFlavors {
        create("develop") { dimension = "default" }
        create("uat") { dimension = "default" }
        create("product") { dimension = "default" }
    }
}

dependencies {
    implementation(libs.paging.runtime)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
