package com.example.gameofthrones.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.example.gameofthrones.domain.GOTPresentation

@Composable
fun Characters(
    modifier: Modifier = Modifier,
    character: GOTPresentation, onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBackground)

    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = character.imageUrl,
            contentScale = ContentScale.FillHeight,
            contentDescription = ""
        )

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = character.fullName,
                color = Color.White,
                maxLines = 1
            )
            Text(
                text = character.title,
                color = Color.White
            )
            Text(
                text = character.family,
                color = Color.White
            )
        }
    }
}