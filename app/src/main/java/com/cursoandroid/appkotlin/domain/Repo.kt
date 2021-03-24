package com.cursoandroid.appkotlin.domain

import com.cursoandroid.appkotlin.data.model.Drink
import com.cursoandroid.appkotlin.vo.Resource

interface Repo {

    suspend fun getTragosList(tragoName: String): Resource<List<Drink>>
}