package com.cursoandroid.appkotlin.data

import com.cursoandroid.appkotlin.AppDatabase
import com.cursoandroid.appkotlin.data.model.Drink
import com.cursoandroid.appkotlin.data.model.DrinkEntity
import com.cursoandroid.appkotlin.vo.Resource
import com.cursoandroid.appkotlin.vo.RetrofitClient
import retrofit2.Retrofit

class DataSource(private val appDatabase: AppDatabase) {

    suspend fun getTragoByName(tragoName: String): Resource<List<Drink>> {
        return Resource.Success(RetrofitClient.webservice.getTragoByName(tragoName).drinkList)
    }


    suspend fun insertTragoRoom(trago: DrinkEntity) {
        appDatabase.tragoDao().insertFavorite(trago)
    }

    suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>> {
        return Resource.Success(appDatabase.tragoDao().getAllFavoriteDrinks())
    }


}