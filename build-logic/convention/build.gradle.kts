plugins {
    `kotlin-dsl`
}

group = "com.example.clear_architecture_base.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.tools.build.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    /**
     * Register convention plugins so they are available in the build scripts of the application
     */
    plugins {
        register("sampleAndroidApplication") {
            id = "example.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("sampleAndroidLibrary") {
            id = "example.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("sampleAndroidTest") {
            id = "example.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("sampleDynamic") {
            id = "example.dynamic"
            implementationClass = "DynamicFeatureConventionPlugin"
        }
    }
}
