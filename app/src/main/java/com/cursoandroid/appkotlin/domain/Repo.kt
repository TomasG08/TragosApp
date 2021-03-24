package com.cursoandroid.appkotlin.domain

import com.cursoandroid.appkotlin.data.model.Drink
import com.cursoandroid.appkotlin.data.model.DrinkEntity
import com.cursoandroid.appkotlin.vo.Resource

interface Repo {

    suspend fun getTragosList(tragoName: String): Resource<List<Drink>>
    suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>>
    suspend fun insertTrago(trago:DrinkEntity)
}