package dam.moviles.ejerapi1.vista

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dam.moviles.ejerapi1.databinding.FragmentMonedasBinding
import dam.moviles.ejerapi1.viewmodel.MonedasFragmentViewModel
import kotlinx.coroutines.launch

class MonedasFragment : Fragment() {

    lateinit var binding: FragmentMonedasBinding
    lateinit var viewModel: MonedasFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        inicializarBinding(inflater,container)
        inicializarViewModel()
        cargarMonedas()
        return binding.root
    }

    fun inicializarBinding(inflater: LayoutInflater,container: ViewGroup?){
        binding=FragmentMonedasBinding.inflate(inflater,container,false)
    }

    fun inicializarViewModel(){
        viewModel = ViewModelProvider(this).get(MonedasFragmentViewModel::class.java)
    }

    fun cargarMonedas(){
        lifecycleScope.launch {
            viewModel.cargarListaMonedas(
                lambdaExito = {
                    inicializarRecyclerView()
                    Log.d("Moneda","GG ${viewModel.listaMonedas}")
                },
                lambdaError = { m ->
                    Log.d("Moneda","GGn't ${m}")
                }
            )
        }
    }

    fun inicializarRecyclerView(){
        binding.lstMonedas.adapter = MonedaAdapter(viewModel.listaMonedas){ holder ->
            //Log.d("Moneda","Pulsado ${holder.moneda.nombre}")
            if(binding.txtCantidad.text.isEmpty()){
                Toast.makeText(
                    requireContext(),
                    "Debe introducir una cantidad",
                    Toast.LENGTH_LONG
                ).show()
            }else if(holder.moneda.codigo=="EUR"){
                Toast.makeText(
                    requireContext(),
                    "Pasar de euros a euros...? vale...????",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                val cantidad:Float = binding.txtCantidad.text.toString().toFloat()
                findNavController().navigate(MonedasFragmentDirections.actionMonedasFragmentToResultadoFragment2(cantidad,holder.moneda.codigo))
            }
        }
    }
}