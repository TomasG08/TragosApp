package com.cursoandroid.appkotlin.ui

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cursoandroid.appkotlin.base.BaseViewHolder
import com.cursoandroid.appkotlin.data.model.Drink

class MainAdapter(private val context: Context, private val tragosList:List<Drink>): RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return tragosList.size
    }

}