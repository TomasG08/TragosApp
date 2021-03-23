package com.cursoandroid.appkotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cursoandroid.appkotlin.R
import com.cursoandroid.appkotlin.data.DataSource
import com.cursoandroid.appkotlin.domain.RepoImp
import com.cursoandroid.appkotlin.ui.viewmodel.MainViewModel
import com.cursoandroid.appkotlin.ui.viewmodel.VMFactory


class MainFragment : Fragment() {

    //inyección de dependencias
    private val viewModel by viewModels<MainViewModel> { VMFactory(RepoImp(DataSource())) }

    lateinit var btn_detalles : Button
    lateinit var rv_tragos : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_tragos = view.findViewById(R.id.rv_tragos)


    }

    private fun setUpRecyclerView(){
        rv_tragos.layoutManager = LinearLayoutManager(requireContext())
        rv_tragos.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }

}