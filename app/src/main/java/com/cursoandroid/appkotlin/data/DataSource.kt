package com.cursoandroid.appkotlin.data

import com.cursoandroid.appkotlin.data.model.Drink
import com.cursoandroid.appkotlin.vo.Resource
import com.cursoandroid.appkotlin.vo.RetrofitClient
import retrofit2.Retrofit

class DataSource {

    suspend fun getTragoByName(tragoName:String): Resource<List<Drink>>{
        return Resource.Success(RetrofitClient.webservice.getTragoByName(tragoName).drinkList)
    }


}