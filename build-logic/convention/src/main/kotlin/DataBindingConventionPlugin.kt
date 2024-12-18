import com.android.build.gradle.BaseExtension
import com.example.clear_architecture_base.configureDataBinding
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class DataBindingConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val extension = extensions.getByType<BaseExtension>()
            configureDataBinding(extension)
        }
    }
}
