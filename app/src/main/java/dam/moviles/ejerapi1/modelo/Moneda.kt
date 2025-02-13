package dam.moviles.ejerapi1.modelo

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Moneda(val codigo: String, val nombre: String)

