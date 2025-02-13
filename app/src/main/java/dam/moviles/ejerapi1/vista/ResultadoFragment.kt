package dam.moviles.ejerapi1.vista

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import dam.moviles.ejerapi1.R
import dam.moviles.ejerapi1.databinding.FragmentMonedasBinding
import dam.moviles.ejerapi1.databinding.FragmentResultadoBinding
import dam.moviles.ejerapi1.viewmodel.MonedasFragmentViewModel
import dam.moviles.ejerapi1.viewmodel.ResultadoFragmentViewModel
import kotlinx.coroutines.launch

class ResultadoFragment : Fragment() {

    lateinit var binding: FragmentResultadoBinding
    lateinit var viewModel: ResultadoFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        inicializarBinding(inflater,container)
        inicializarViewModel()
        lifecycleScope.launch {
            cargarCambio()
        }
        return binding.root
    }

    suspend fun cargarCambio(){
        viewModel.generarCambio(
            lambdaExito = {
                binding.txtResultado.text = "${viewModel.cantidad} EUR = ${viewModel.cambio} ${viewModel.divisa}"
            },
            lambdaError = {m ->
                Log.d("Moneda",m)
            }
        )
    }

    fun inicializarViewModel(){
        viewModel = ViewModelProvider(this).get(ResultadoFragmentViewModel::class.java)
        viewModel.divisa = ResultadoFragmentArgs.fromBundle(requireArguments()).divisa
        viewModel.cantidad = ResultadoFragmentArgs.fromBundle(requireArguments()).cantidad
    }

    fun inicializarBinding(inflater: LayoutInflater,container: ViewGroup?){
        binding= FragmentResultadoBinding.inflate(inflater,container,false)
    }
}