package com.example.gameofthrones.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.gameofthrones.data.GOTRepository
import com.example.gameofthrones.domain.GOTListDomain
import com.example.gameofthrones.domain.GOTPresentation
import com.example.gameofthrones.utils.GameOfThronesService
import com.example.gameofthrones.utils.RetrofitAPI
import kotlinx.coroutines.launch

class GOTListViewModel (private val repository: GOTRepository): ViewModel(){
    private val _listCharacter: MutableLiveData<List<GOTPresentation>> = MutableLiveData()
    val listCharacters: LiveData<List<GOTPresentation>> = _listCharacter

    fun listCharacter(){
        viewModelScope.launch {
            val result = repository.getCharacters()
            val domain = GOTListDomain()
            _listCharacter.value = domain.mapToPresentation(result)
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T: ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T{
                val retrofit = RetrofitAPI.getRetrofit()
                val service = retrofit.create(GameOfThronesService::class.java)
                val repository = GOTRepository(service)

                return GOTListViewModel(repository) as T
            }
        }
    }
}