package com.cursoandroid.appkotlin.domain

import com.cursoandroid.appkotlin.data.model.Drink
import com.cursoandroid.appkotlin.data.model.DrinkEntity
import com.cursoandroid.appkotlin.vo.Resource
import com.cursoandroid.appkotlin.vo.RetrofitClient

/**
 * Created by Tomás Guzmán on 24/03/2021.
 */
interface DataSource {

    suspend fun getTragoByName(tragoName: String): Resource<List<Drink>>
    suspend fun insertTragoRoom(trago: DrinkEntity)
    suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>>
    suspend fun deleteTrago(trago: DrinkEntity)
}