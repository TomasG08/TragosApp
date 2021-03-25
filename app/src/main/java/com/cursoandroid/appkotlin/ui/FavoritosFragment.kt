package com.cursoandroid.appkotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.cursoandroid.appkotlin.AppDatabase
import com.cursoandroid.appkotlin.R
import com.cursoandroid.appkotlin.data.DataSourceImpl
import com.cursoandroid.appkotlin.data.model.Drink
import com.cursoandroid.appkotlin.databinding.FragmentFavoritosBinding
import com.cursoandroid.appkotlin.domain.RepoImpl
import com.cursoandroid.appkotlin.ui.viewmodel.MainViewModel
import com.cursoandroid.appkotlin.ui.viewmodel.VMFactory
import com.cursoandroid.appkotlin.vo.Resource


class FavoritosFragment : Fragment(R.layout.fragment_favoritos), MainAdapter.OnTragoClickListener {

    private val viewModel by viewModels<MainViewModel> {
        VMFactory(
            RepoImpl(
                DataSourceImpl(
                    AppDatabase.getDatabase(
                        requireActivity().applicationContext
                    )
                )
            )
        )
    }
    private lateinit var binding: FragmentFavoritosBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoritosBinding.bind(view)
        setUpRecyclerView()
        setUpObservers()

    }

    private fun setUpObservers() {
        viewModel.getTragosFavoritos().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    val lista = result.data.map {
                        Drink(it.tragoId, it.imagen, it.nombre, it.descripcion, it.hasAlcohol)
                    }
                    binding.rvTragosFavoritos.adapter = MainAdapter(requireContext(), lista, this)
                }
                is Resource.Failure -> {
                }
            }
        })
    }

    private fun setUpRecyclerView() {
        binding.rvTragosFavoritos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTragosFavoritos.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun onTragoClickListener(drink: Drink, position: Int) {

        /*
        viewModel.deleteTrago(drink)
        binding.rvTragosFavoritos.adapter?.notifyItemRemoved(position)
        binding.rvTragosFavoritos.adapter?.notifyItemRangeRemoved(
            position,
            binding.rvTragosFavoritos.adapter?.itemCount!!
        )
        Toast.makeText(requireContext(), "Bebida eliminada", Toast.LENGTH_SHORT).show()
*/
        val bundle = Bundle()
        bundle.putParcelable("drink", drink)
        findNavController().navigate(R.id.action_favoritosFragment_to_tragosDetalleFragment, bundle)
    }
}