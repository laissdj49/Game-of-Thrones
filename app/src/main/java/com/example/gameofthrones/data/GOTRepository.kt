package com.example.gameofthrones.data

import com.example.gameofthrones.data.response.GOTCharactersResponse
import com.example.gameofthrones.utils.GameOfThronesService

class GOTRepository (private val service: GameOfThronesService){

    suspend fun getCharacters(): List<GOTCharactersResponse> {
        return service.getCharacters()
    }
}