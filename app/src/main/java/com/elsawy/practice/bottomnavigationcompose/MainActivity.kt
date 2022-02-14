package com.elsawy.practice.bottomnavigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.elsawy.practice.bottomnavigationcompose.ui.theme.BottomNavigationComposeTheme

class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         MainScreen()
      }
   }
}

@Composable
private fun MainScreen() {
   val navController = rememberNavController()
   Scaffold(modifier = Modifier.fillMaxSize(),
      bottomBar = { BottomNavigationBar(navController) }
   ) {
      NavigationGraph(navController)
   }
}

@Composable
private fun BottomNavigationBar(navController: NavController) {
   val items = listOf(NavigationItem.Home,
      NavigationItem.Music,
      NavigationItem.Books,
      NavigationItem.Search,
      NavigationItem.Profile)

   BottomNavigation(
      backgroundColor = colorResource(id = R.color.purple_700),
      contentColor = Color.White
   ) {
      val navBackStackEntry by navController.currentBackStackEntryAsState()
      val currentRoute = navBackStackEntry?.destination?.route

      items.forEach { item ->
         BottomNavigationItem(
            icon = {
               Icon(painter = painterResource(id = item.icon),
                  contentDescription = item.title)
            },
            label = { Text(text = item.title, fontSize = 16.sp) },
            selectedContentColor = Color.White,
            unselectedContentColor = Color.White.copy(.4f),
            selected = currentRoute == item.route,
            onClick = {
               navController.navigate(item.route) {
                  navController.graph.startDestinationRoute?.let { route ->
                     popUpTo(route) {
                        saveState = true
                     }
                  }
                  // Avoid multiple copies of the same destination when reselecting the same item
                  launchSingleTop = true
                  // Restore state when reselecting a previously selected item
                  restoreState = true
               }
            })
      }
   }
}

@Composable
private fun NavigationGraph(navController: NavHostController) {
   NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
      composable(NavigationItem.Home.route) {
         HomeScreen()
      }
      composable(NavigationItem.Music.route) {
         MusicScreen()
      }
      composable(NavigationItem.Books.route) {
         BooksScreen()
      }
      composable(NavigationItem.Search.route) {
         SearchScreen()
      }
      composable(NavigationItem.Profile.route) {
         ProfileScreen()
      }
   }
}

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
   object Home : NavigationItem("home", R.drawable.ic_home, "Home")
   object Music : NavigationItem("music", R.drawable.ic_music, "Music")
   object Books : NavigationItem("books", R.drawable.ic_book, "Books")
   object Search : NavigationItem("search", R.drawable.ic_search, "Search")
   object Profile : NavigationItem("profile", R.drawable.ic_profile, "Profile")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
   BottomNavigationComposeTheme {
      MainScreen()
   }
}