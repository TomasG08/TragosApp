package com.cursoandroid.appkotlin.domain

import com.cursoandroid.appkotlin.data.model.Drink
import com.cursoandroid.appkotlin.vo.Resource

interface Repo {

    fun getTragosList() : Resource<List<Drink>>
}