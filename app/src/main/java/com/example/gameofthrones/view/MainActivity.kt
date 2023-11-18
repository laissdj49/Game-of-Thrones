package com.example.gameofthrones.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gameofthrones.ui.theme.GameOfThronesTheme

class MainActivity : ComponentActivity() {

    private val viewModel: GOTListViewModel by viewModels { GOTListViewModel.Factory }

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            viewModel.listCharacter()
            GameOfThronesTheme {
                viewModel.listCharacter()
                val character by viewModel.listCharacters.collectAsState()
                val pagerState = rememberPagerState(pageCount = {
                    character.size
                })
                VerticalPager(state = pagerState) { page ->
                    Characters(
                        modifier = Modifier,
                        character = character[page]
                    ) {
                    }
                }
            }
        }
    }


    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        GameOfThronesTheme {
            Greeting("Android")
        }
    }
}