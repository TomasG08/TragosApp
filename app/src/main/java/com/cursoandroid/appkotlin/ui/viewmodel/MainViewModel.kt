package com.cursoandroid.appkotlin.ui.viewmodel

import androidx.lifecycle.*
import com.cursoandroid.appkotlin.domain.Repo
import com.cursoandroid.appkotlin.vo.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception


class MainViewModel(private val repo: Repo) : ViewModel() {

    private val tragosData = MutableLiveData<String>()

    fun setTrago(tragoName: String) {
        tragosData.value = tragoName
    }
    init {
        setTrago("margarita")
    }

    val fetchTragosList = tragosData.distinctUntilChanged().switchMap {nombreTrago ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(repo.getTragosList(nombreTrago))
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }
    }
}