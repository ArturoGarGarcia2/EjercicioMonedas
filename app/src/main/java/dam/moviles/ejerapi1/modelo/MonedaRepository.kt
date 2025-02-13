package dam.moviles.ejerapi1.modelo

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class MonedaRepository {
    val monedaAPI:MonedaApiService
    init {
        monedaAPI = Retrofit.Builder()
            .baseUrl("https://api.frankfurter.dev/v1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    suspend fun getMonedas():Map<String,String> =
        monedaAPI.obtenerMonedas()

    suspend fun getCambio(divisa: String):CambioResponse =
        monedaAPI.getCambio("EUR",divisa)
}