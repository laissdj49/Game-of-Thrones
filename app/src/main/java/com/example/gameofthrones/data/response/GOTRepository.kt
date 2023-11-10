package com.example.gameofthrones.data.response

import com.example.gameofthrones.utils.GameOfThronesService

class GOTRepository (private val service: GameOfThronesService){

    suspend fun getCharacters(): List<GOTCharactersResponse> {
        return service.getCharacters()
    }
}