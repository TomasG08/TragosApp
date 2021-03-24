package com.cursoandroid.appkotlin.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.cursoandroid.appkotlin.AppDatabase
import com.cursoandroid.appkotlin.R
import com.cursoandroid.appkotlin.data.DataSource
import com.cursoandroid.appkotlin.domain.RepoImp
import com.cursoandroid.appkotlin.ui.viewmodel.MainViewModel
import com.cursoandroid.appkotlin.ui.viewmodel.VMFactory
import com.cursoandroid.appkotlin.vo.Resource


class FavoritosFragment : Fragment(R.layout.fragment_favoritos) {

    private val viewModel by viewModels<MainViewModel> { VMFactory(RepoImp(DataSource(AppDatabase.getDatabase(requireActivity().applicationContext)))) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getTragosFavoritos().observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    Log.d("Lista_favoritos", "${it.data}")
                }
                is Resource.Failure -> {
                }
            }
        })
    }
}