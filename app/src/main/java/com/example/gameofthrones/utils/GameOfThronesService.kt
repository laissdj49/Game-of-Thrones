package com.example.gameofthrones.utils

import com.example.gameofthrones.data.response.GOTCharactersResponse
import retrofit2.Call
import retrofit2.http.GET

interface GameOfThronesService {
    /**
     * Interface necessaria para o retrofit gerar o codigo para realizar uma requisicao
     */

    @GET("characters")
    suspend fun getCharacters(): List<GOTCharactersResponse>
}