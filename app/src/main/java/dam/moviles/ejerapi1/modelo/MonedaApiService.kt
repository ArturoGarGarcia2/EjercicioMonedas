package dam.moviles.ejerapi1.modelo

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface MonedaApiService {
    @GET("currencies")
    suspend fun obtenerMonedas(): Map<String,String>

    @GET("latest")
    suspend fun getCambio(
        @Query("base") base: String,
        @Query("symbols") symbol: String,
    ):CambioResponse
}