package com.cursoandroid.appkotlin.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.cursoandroid.appkotlin.R
import com.cursoandroid.appkotlin.data.model.Drink
import com.cursoandroid.appkotlin.databinding.FragmentMainBinding
import com.cursoandroid.appkotlin.databinding.FragmentTragosDetalleBinding

class TragosDetalleFragment : Fragment(R.layout.fragment_tragos_detalle) {

    private lateinit var drink: Drink
    private lateinit var binding: FragmentTragosDetalleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTragosDetalleBinding.bind(view)
        requireArguments().let {
            drink = it.getParcelable("drink")!!
            Log.d("Detalles_Fragment", "Drink: $drink")

        }
        Glide.with(requireContext()).load(drink.imagen).centerCrop().into(binding.imgTrago)
        binding.tragoTitle.text = drink.nombre
        binding.tragoDesc.text = drink.descripcion
        if(drink.hasAlcohol == "Non_Alcoholic"){
            binding.tragoHasAlcohol.text = "Bebida sin alcohol"
        }else{
            binding.tragoHasAlcohol.text = "Bebida con alcohol"
        }

    }

}