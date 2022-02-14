package com.elsawy.practice.bottomnavigationcompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.elsawy.practice.bottomnavigationcompose.ui.theme.BottomNavigationComposeTheme

@Composable
fun HomeScreen() {
   Box(modifier = Modifier.fillMaxSize()) {
      Text(text = "HomeScreen", fontSize = 30.sp, modifier = Modifier.align(Alignment.Center))
   }
}

@Composable
fun MusicScreen() {
   Box(modifier = Modifier.fillMaxSize()) {
      Text(text = "MusicScreen", fontSize = 30.sp, modifier = Modifier.align(Alignment.Center))
   }
}

@Composable
fun BooksScreen() {
   Box(modifier = Modifier.fillMaxSize()) {
      Text(text = "BooksScreen", fontSize = 30.sp, modifier = Modifier.align(Alignment.Center))
   }
}

@Composable
fun SearchScreen() {
   Box(modifier = Modifier.fillMaxSize()) {
      Text(text = "SearchScreen", fontSize = 30.sp, modifier = Modifier.align(Alignment.Center))
   }
}

@Composable
fun ProfileScreen() {
   Box(modifier = Modifier.fillMaxSize()) {
      Text(text = "ProfileScreen", fontSize = 30.sp, modifier = Modifier.align(Alignment.Center))
   }
}

// Pop up to the start destination of the graph to
                  // avoid building up a large stack of destinations
                  // on the back stack as users select items
@Preview(showBackground = true)
@Composable
fun HomePreview() {
   BottomNavigationComposeTheme {
      HomeScreen()
   }
}