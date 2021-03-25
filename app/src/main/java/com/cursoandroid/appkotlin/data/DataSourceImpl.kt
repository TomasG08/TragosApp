package com.cursoandroid.appkotlin.data

import com.cursoandroid.appkotlin.AppDatabase
import com.cursoandroid.appkotlin.data.model.Drink
import com.cursoandroid.appkotlin.data.model.DrinkEntity
import com.cursoandroid.appkotlin.domain.DataSource
import com.cursoandroid.appkotlin.vo.Resource
import com.cursoandroid.appkotlin.vo.RetrofitClient

class DataSourceImpl(private val appDatabase: AppDatabase): DataSource {

    override suspend fun getTragoByName(tragoName: String): Resource<List<Drink>> {
        return Resource.Success(RetrofitClient.webservice.getTragoByName(tragoName).drinkList)
    }


    override suspend fun insertTragoRoom(trago: DrinkEntity) {
        appDatabase.tragoDao().insertFavorite(trago)
    }

    override suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>> {
        return Resource.Success(appDatabase.tragoDao().getAllFavoriteDrinks())
    }

    override suspend fun deleteTrago(trago: DrinkEntity){
        appDatabase.tragoDao().deleteDrink(trago)
    }


}