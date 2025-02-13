package dam.moviles.ejerapi1.viewmodel

import androidx.lifecycle.ViewModel
import dam.moviles.ejerapi1.modelo.Moneda
import dam.moviles.ejerapi1.modelo.MonedaRepository

class ResultadoFragmentViewModel: ViewModel() {

    var cambio: Float = 0f
    var divisa: String = ""
    var cantidad: Float = 0f;

    suspend fun generarCambio(
        lambdaExito: ()-> Unit,
        lambdaError: (String)-> Unit
    ){
        try{
            cambio = MonedaRepository().getCambio(divisa).rates.get(divisa).toString().toFloat()*cantidad
            lambdaExito()
        }catch (e:Exception){
            lambdaError(e.message.toString())
        }
    }
}
