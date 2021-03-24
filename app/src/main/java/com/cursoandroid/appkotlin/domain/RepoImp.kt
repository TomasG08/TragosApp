package com.cursoandroid.appkotlin.domain

import com.cursoandroid.appkotlin.data.DataSource
import com.cursoandroid.appkotlin.data.model.Drink
import com.cursoandroid.appkotlin.data.model.DrinkEntity
import com.cursoandroid.appkotlin.vo.Resource

class RepoImp(private val dataSource: DataSource) : Repo {
    override suspend fun getTragosList(tragoName: String): Resource<List<Drink>> {
        return dataSource.getTragoByName(tragoName)
    }

    override suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>> {
        return dataSource.getTragosFavoritos()
    }

    override suspend fun insertTrago(trago: DrinkEntity) {
       dataSource.insertTragoRoom(trago)
    }
}