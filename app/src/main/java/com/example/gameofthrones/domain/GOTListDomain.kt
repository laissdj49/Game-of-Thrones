package com.example.gameofthrones.domain

import com.example.gameofthrones.data.response.GOTCharactersResponse

class GOTListDomain {

    fun mapToPresentation(
        characters: List<GOTCharactersResponse>
    ): List<GOTPresentation>{
        return characters
            .filter {item -> item.image.isNotEmpty() }
            .map { item ->
                GOTPresentation(
                    firstName = item.firstName,
                    lastName = item.lastName,
                    fullName = item.fullName,
                    title = item.title,
                    family = item.family,
                    imageUrl = item.family,
                    image = item.image,
                    id = item.id
                )
            }
    }

}
data class GOTPresentation(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val fullName: String,
    val title: String,
    val family: String,
    val imageUrl: String,
    val image: String
)