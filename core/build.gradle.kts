plugins {
    alias(libs.plugins.example.android.library)
    alias(libs.plugins.detekt)
    alias(libs.plugins.ktlint)
    id("androidx.navigation.safeargs.kotlin")
}

ktlint {
    verbose.set(true)
    android.set(true)
    outputToConsole.set(true)
}

android {
    namespace = "com.example.clear_architecture_base.core"

    buildFeatures {
        dataBinding = true
    }

    // To avoid warning for modules which they have no flavor
    flavorDimensions.add("default")
    productFlavors {
        create("develop") { dimension = "default" }
        create("uat") { dimension = "default" }
        create("product") { dimension = "default" }
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    implementation(libs.glide.runtime)
    implementation(libs.glide.compiler)
    implementation(libs.glide.recyclerview.integration)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.test)

    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    implementation(libs.androidx.fragment.ktx)
    implementation(libs.paging.runtime)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    testImplementation(libs.junit)
}
