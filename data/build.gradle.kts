plugins {
    alias(libs.plugins.example.android.library)
}

android {
    namespace = "com.example.data"

    buildFeatures {
        buildConfig = true
    }

    flavorDimensions.add("default")

    productFlavors {
        create("develop") {
            buildConfigField(
                "String",
                "BASE_API_URL",
                "\"https://api.test.com/\""
            )
        }
        create("uat") {
            buildConfigField(
                "String",
                "BASE_API_URL",
                "\"https://api.test.com/\""
            )
        }
        create("product") {
            buildConfigField(
                "String",
                "BASE_API_URL",
                "\"https://api.test.com/\""
            )
        }
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.gson)
    implementation(libs.logging.interceptor)

    implementation(libs.paging.runtime)
    implementation(libs.security.crypto.ktx)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}