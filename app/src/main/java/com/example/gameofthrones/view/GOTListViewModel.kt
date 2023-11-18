package com.example.gameofthrones.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.gameofthrones.data.GOTRepository
import com.example.gameofthrones.domain.GOTListDomain
import com.example.gameofthrones.domain.GOTPresentation
import com.example.gameofthrones.utils.GameOfThronesService
import com.example.gameofthrones.utils.RetrofitAPI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GOTListViewModel(private val repository: GOTRepository) : ViewModel() {
    private val _listCharacter = MutableStateFlow(listOf( GOTPresentation()))
    val listCharacters: StateFlow<List<GOTPresentation>> = _listCharacter.asStateFlow()

    fun listCharacter() {
        viewModelScope.launch {
            val result = repository.getCharacters()
            val domain = GOTListDomain()
            _listCharacter.value = domain.mapToPresentation(result)
            Log.d("requisição",result.toString())

        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val retrofit = RetrofitAPI.getRetrofit()
                val service = retrofit.create(GameOfThronesService::class.java)
                val repository = GOTRepository(service)

                return GOTListViewModel(repository) as T
            }
        }
    }
}