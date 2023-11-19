package com.example.gameofthrones.domain

import androidx.compose.ui.graphics.Color
import com.example.gameofthrones.data.response.GOTCharactersResponse

class GOTListDomain {

    private val colors = listOf(Color.Red, Color.Blue, Color.Yellow, Color.Magenta, Color.Green)
    fun mapToPresentation(
        characters: List<GOTCharactersResponse>
    ): List<GOTPresentation> {
        return characters
            .filter { item -> item.image.isNotEmpty() }
            .map { item ->
                GOTPresentation(
                    shadowColor = colors.random(),
                    firstName = item.firstName,
                    lastName = item.lastName,
                    fullName = item.fullName,
                    title = item.title,
                    family = item.family,
                    imageUrl = item.imageUrl,
                    image = item.image,
                    id = item.id
                )
            }
    }
}
data class GOTPresentation(
    val shadowColor: Color = Color.Transparent,
    val id: Int = 0,
    val firstName: String = "",
    val lastName: String = "",
    val fullName: String = "",
    val title: String = "",
    val family: String = "",
    val imageUrl: String = "",
    val image: String = ""
)