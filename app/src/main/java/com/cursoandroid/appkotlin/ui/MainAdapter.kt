package com.cursoandroid.appkotlin.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cursoandroid.appkotlin.R
import com.cursoandroid.appkotlin.base.BaseViewHolder
import com.cursoandroid.appkotlin.data.model.Drink
import com.cursoandroid.appkotlin.databinding.TragosRowBinding

class MainAdapter(
    private val context: Context,
    private val tragosList: List<Drink>,
    private val itemClickListener: OnTragoClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnTragoClickListener{
        fun onTragoClickListener(drink: Drink, position: Int)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            TragosRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = MainViewHolder(itemBinding, parent.context)

        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.bind(tragosList[position], position)
        }
    }

    override fun getItemCount(): Int {
        return tragosList.size
    }

    inner class MainViewHolder(val binding: TragosRowBinding, val context: Context) :
        BaseViewHolder<Drink>(binding.root) {
        override fun bind(item: Drink, position: Int) {
            Glide.with(context).load(item.imagen).centerCrop().into(binding.imageTrago)
            binding.txtTitulo.text = item.nombre
            binding.txtDescripcion.text = item.descripcion
            itemView.setOnClickListener{itemClickListener.onTragoClickListener(item, position)}
        }
    }

}