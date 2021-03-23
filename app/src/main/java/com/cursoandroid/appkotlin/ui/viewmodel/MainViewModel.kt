package com.cursoandroid.appkotlin.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.cursoandroid.appkotlin.domain.Repo
import com.cursoandroid.appkotlin.vo.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception


class MainViewModel(private val repo:Repo):ViewModel() {

    val fetchTragosList = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getTragosList())
        }catch (e : Exception){
            emit(Resource.Failure(e))
        }
    }
}