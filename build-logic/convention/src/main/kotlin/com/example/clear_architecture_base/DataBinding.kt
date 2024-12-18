package com.example.clear_architecture_base

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

@Suppress("UnstableApiUsage")
internal fun Project.configureDataBinding(commonExtension: BaseExtension) {
    commonExtension.apply {

//        buildFeatures.apply {
//            dataBinding = true
//        }

        dataBinding {
            enable = true
        }

        val libs: VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

        // Optional: Add Data Binding runtime dependency
        dependencies {
            add("implementation", libs.findLibrary("androidx.databinding.runtime").get())
        }
    }
}
