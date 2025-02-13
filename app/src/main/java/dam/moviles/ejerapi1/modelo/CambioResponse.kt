package dam.moviles.ejerapi1.modelo

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CambioResponse(
    val amount: Int,
    val base: String,
    val date: String,
    val rates: Map<String,String>
)
