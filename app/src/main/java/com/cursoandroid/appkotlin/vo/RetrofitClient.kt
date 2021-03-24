package com.cursoandroid.appkotlin.vo

import com.cursoandroid.appkotlin.domain.WebService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Tomás Guzmán on 24/03/2021.
 */
object RetrofitClient {

    val webservice by lazy {
        Retrofit.Builder().baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}