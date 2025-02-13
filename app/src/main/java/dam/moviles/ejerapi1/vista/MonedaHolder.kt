package dam.moviles.ejerapi1.vista

import androidx.recyclerview.widget.RecyclerView
import dam.moviles.ejerapi1.databinding.MonedaBinding
import dam.moviles.ejerapi1.modelo.Moneda

class MonedaHolder(val binding: MonedaBinding) : RecyclerView.ViewHolder(binding.root) {
    lateinit var moneda: Moneda

    fun mostrarMonedas(m:Moneda){
        moneda = m
        binding.txtNombre.text = moneda.nombre
    }
}
