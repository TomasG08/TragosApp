package com.cursoandroid.appkotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.cursoandroid.appkotlin.AppDatabase
import com.cursoandroid.appkotlin.R
import com.cursoandroid.appkotlin.data.DataSourceImpl
import com.cursoandroid.appkotlin.data.model.Drink
import com.cursoandroid.appkotlin.data.model.DrinkEntity
import com.cursoandroid.appkotlin.databinding.FragmentTragosDetalleBinding
import com.cursoandroid.appkotlin.domain.RepoImpl
import com.cursoandroid.appkotlin.ui.viewmodel.MainViewModel
import com.cursoandroid.appkotlin.ui.viewmodel.VMFactory

class TragosDetalleFragment : Fragment(R.layout.fragment_tragos_detalle) {

    private val viewModel by viewModels<MainViewModel> { VMFactory(RepoImpl(DataSourceImpl(AppDatabase.getDatabase(requireActivity().applicationContext)))) }
    private lateinit var drink: Drink
    private lateinit var binding: FragmentTragosDetalleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTragosDetalleBinding.bind(view)
        requireArguments().let {
            drink = it.getParcelable("drink")!!
        }
        Glide.with(requireContext()).load(drink.imagen).centerCrop().into(binding.imgTrago)
        binding.tragoTitle.text = drink.nombre
        binding.tragoDesc.text = drink.descripcion
        /*
        if (drink.hasAlcohol == "Non_Alcoholic") {
            binding.tragoHasAlcohol.text = "Bebida sin alcohol"
        } else {
            binding.tragoHasAlcohol.text = "Bebida con alcohol"
        }
        */

        binding.fabAddFavDrink.setOnClickListener {
            viewModel.guardarTrago(
                DrinkEntity(
                    drink.tragoId,
                    drink.imagen,
                    drink.nombre,
                    drink.descripcion,
                    drink.hasAlcohol
                )
            )
            Toast.makeText(requireContext(), "El trago se guardó en favoritos", Toast.LENGTH_SHORT)
                .show()
        }

    }

}