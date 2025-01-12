import com.example.data.repository.remote.api.response.ErrorResponse
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class ErrorDeserializer : JsonDeserializer<Any?> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Any? {
        return when {
            json != null && json.isJsonObject -> {
                context?.deserialize(json, ErrorResponse.Error::class.java)
            }

            json != null && json.isJsonPrimitive -> {
                json.asString
            }

            else -> {
                null
            }
        }
    }
}
