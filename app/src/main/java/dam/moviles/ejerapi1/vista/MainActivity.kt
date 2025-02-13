package dam.moviles.ejerapi1.vista

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dam.moviles.ejerapi1.R
import dam.moviles.ejerapi1.modelo.CambioResponse
import dam.moviles.ejerapi1.modelo.Moneda
import dam.moviles.ejerapi1.modelo.MonedaRepository
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test()
    }

    fun test(){
        lifecycleScope.launch {
            val cambio:CambioResponse = MonedaRepository().getCambio("USD")
            Log.d("Moneda", checkNotNull(cambio.rates.get("USD")))
        }
    }
}