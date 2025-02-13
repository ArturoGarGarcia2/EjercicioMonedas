package dam.moviles.ejerapi1.viewmodel

import androidx.lifecycle.ViewModel
import dam.moviles.ejerapi1.modelo.Moneda
import dam.moviles.ejerapi1.modelo.MonedaRepository

class MonedasFragmentViewModel: ViewModel() {
    var listaMonedas: List<Moneda> = emptyList()

    suspend fun cargarListaMonedas(
        lambdaExito: ()-> Unit,
        lambdaError: (String)-> Unit
    ){
        try{
            listaMonedas = MonedaRepository().getMonedas()
                .filter{ m -> m.key!="EUR" }
                .map { m -> Moneda(m.key,m.value)
            }
            lambdaExito()
        }catch (e:Exception){
            lambdaError(e.message.toString())
        }
    }
}