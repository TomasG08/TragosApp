package com.cursoandroid.appkotlin.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cursoandroid.appkotlin.R
import com.cursoandroid.appkotlin.data.model.Drink

class TragosDetalleFragment : Fragment(R.layout.fragment_tragos_detalle) {

    private lateinit var drink: Drink

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireArguments().let {
            drink = it.getParcelable("drink")!!
            Log.d("Detalles_Fragment", "Drink: $drink")

        }
    }

}