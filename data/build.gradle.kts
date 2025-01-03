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
    namespace = "com.example.clear_architecture_base.data"

    buildFeatures {
        buildConfig = true
    }

    flavorDimensions.add("default")

    productFlavors {
        create("develop") {
            buildConfigField(
                "String",
                "BASE_API_URL",
                "\"https://api.themoviedb.org/\""
            )
        }
        create("uat") {
            buildConfigField(
                "String",
                "BASE_API_URL",
                "\"https://api.themoviedb.org/\""
            )
        }
        create("product") {
            buildConfigField(
                "String",
                "BASE_API_URL",
                "\"https://api.themoviedb.org/\""
            )
        }
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":shared"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.gson)
    implementation(libs.logging.interceptor)

    implementation(libs.paging.runtime)
    implementation(libs.security.crypto.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
