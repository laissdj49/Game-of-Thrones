package com.example.gameofthrones.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            .padding(16.dp)

    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = character.imageUrl,
            contentScale = ContentScale.FillHeight,
            contentDescription = ""
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = character.firstName,
                color = Color.Red,
                modifier = modifier.shadow(elevation = 20.dp, spotColor = Color.Red),
                style = TextStyle(
                    fontFamily = FontFamily.Cursive,
                    textDecoration = TextDecoration.Underline
                ),
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
                maxLines = 1
            )
            Text(
                text = character.lastName,
                modifier = modifier.padding(start = 20.dp),
                style = TextStyle(
                    fontFamily = FontFamily.Cursive,
                    textDecoration = TextDecoration.Underline
                ),
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
                maxLines = 1
            )
            Text(
                text = character.title,
                modifier = modifier,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                style = TextStyle(fontStyle = FontStyle.Italic),
                fontSize = 20.sp,
                maxLines = 2
            )
            Text(
                text = character.family,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                style = TextStyle(fontStyle = FontStyle.Italic),
                fontSize = 20.sp,
            )
        }
    }
}