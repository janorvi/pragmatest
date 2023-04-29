package com.example.pragmatest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pragmatest.model.Cat
import com.example.pragmatest.service.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(api: ApiService): ViewModel(){

    private val _catList = MutableLiveData<List<Cat>>()
    val catList: LiveData<List<Cat>> get() = _catList

    private val _catListFailed = MutableLiveData<String>()
    val catListFailed: LiveData<String> get() = _catListFailed

    var api: ApiService

    init{
        this.api = api
    }

    fun getCatList(){
        viewModelScope.launch {
            try{
                val response = api.getCatList()
                if(response != null){
                    _catList.postValue(response.body())
                }else{
                    _catListFailed.postValue("Response is null")
                }
            }catch (e: Exception){
                _catListFailed.postValue("Get cats was failed:$e")
            }
        }
    }
}