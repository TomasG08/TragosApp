package com.cursoandroid.appkotlin.ui.viewmodel

import android.widget.Toast
import androidx.lifecycle.*
import com.cursoandroid.appkotlin.data.model.Drink
import com.cursoandroid.appkotlin.data.model.DrinkEntity
import com.cursoandroid.appkotlin.domain.Repo
import com.cursoandroid.appkotlin.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception


class MainViewModel(private val repo: Repo) : ViewModel() {

    private val tragosData = MutableLiveData<String>()

    fun setTrago(tragoName: String) {
        tragosData.value = tragoName
    }

    init {
        setTrago("margarita")
    }

    val fetchTragosList = tragosData.distinctUntilChanged().switchMap { nombreTrago ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(repo.getTragosList(nombreTrago))
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }
    }

    fun guardarTrago(trago: DrinkEntity) {
        viewModelScope.launch {
            repo.insertTrago(trago)
        }
    }

    fun getTragosFavoritos() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getTragosFavoritos())
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun deleteTrago(drink : Drink){
    }

}