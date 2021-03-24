package com.cursoandroid.appkotlin.domain

import com.cursoandroid.appkotlin.data.DataSource
import com.cursoandroid.appkotlin.data.model.Drink
import com.cursoandroid.appkotlin.vo.Resource

class RepoImp(private val dataSource: DataSource) : Repo {
    override suspend fun getTragosList(tragoName: String): Resource<List<Drink>> {
        return dataSource.getTragoByName(tragoName)
    }
}