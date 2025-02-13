package dam.moviles.ejerapi1.vista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dam.moviles.ejerapi1.databinding.MonedaBinding
import dam.moviles.ejerapi1.modelo.Moneda

class MonedaAdapter(
    var monedas:List<Moneda>,
    var lambda: (MonedaHolder) -> Unit
) : RecyclerView.Adapter<MonedaHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonedaHolder =
        MonedaHolder(MonedaBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount(): Int = monedas.size

    override fun onBindViewHolder(holder: MonedaHolder, position: Int) {
        val moneda =monedas.get(position)
        holder.mostrarMonedas(moneda)
        holder.binding.root.setOnClickListener{
            lambda(holder)
        }
    }
}