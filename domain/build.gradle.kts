plugins {
    alias(libs.plugins.example.android.library)
    alias(libs.plugins.detekt)
    alias(libs.plugins.ktlint)
}

ktlint {
    verbose.set(true)
    android.set(true)
    outputToConsole.set(true)
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
