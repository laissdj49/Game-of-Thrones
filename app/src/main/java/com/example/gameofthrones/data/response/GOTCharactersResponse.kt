package com.example.gameofthrones.data.response

data class GOTCharactersResponse(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val fullName: String,
    val title: String,
    val family: String,
    val imageUrl: String,
    val image: String
)
