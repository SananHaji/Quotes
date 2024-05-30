package com.sananhaji.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sananhaji.presentation_common.navigation.NavRoutes
import com.sananhaji.presentation_home.HomeScreen
import com.sananhaji.presentation_settings.SettingsScreen
import com.sananhaji.quotes.ui.theme.QuotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    Scaffold(
                        modifier = Modifier.fillMaxSize(), // Fills the entire screen
                        bottomBar = {
                            BottomAppBar(
                                content = {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 8.dp),
                                        horizontalArrangement = Arrangement.SpaceEvenly // Distribute icons
                                    ) {
                                        IconButton(onClick = { navController.navigate(NavRoutes.Home.route) }) {
                                            Icon(
                                                painter = painterResource(id = com.google.android.material.R.drawable.ic_keyboard_black_24dp),
                                                contentDescription = "Main"
                                            )
                                        }
                                        IconButton(onClick = { navController.navigate(NavRoutes.Favorites.route) }) {
                                            Icon(
                                                painter = painterResource(id = com.sananhaji.presentation_home.R.drawable.ic_heart_gray),
                                                contentDescription = "Favorites"
                                            )
                                        }
                                        IconButton(onClick = { navController.navigate(NavRoutes.Settings.route) }) {
                                            Icon(
                                                imageVector = Icons.Filled.Settings,
                                                contentDescription = "Settings"
                                            )
                                        }
                                    }
                                }
                            )
                        }
                    ) {
                        App(modifier = Modifier.padding(it), navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier, navController: NavHostController) {
    NavHost(modifier = modifier, navController = navController, startDestination = NavRoutes.Home.route) {
        composable(route = NavRoutes.Home.route) {
            HomeScreen(hiltViewModel(), navController)
        }
        composable(route = NavRoutes.Favorites.route) {
            HomeScreen(hiltViewModel(), navController)
        }
        composable(route = NavRoutes.Settings.route) {
            SettingsScreen(hiltViewModel(), navController)
        }
//        composable(
//            route = NavRoutes.Post.route,
//            arguments = NavRoutes.Post.arguments
//        ) {
//            PostScreen(
//                hiltViewModel(),
//                NavRoutes.Post.fromEntry(it)
//            )
//        }
//        composable(
//            route = NavRoutes.User.route,
//            arguments = NavRoutes.User.arguments
//        ) {
//            UserScreen(
//                hiltViewModel(),
//                NavRoutes.User.fromEntry(it)
//            )
//        }
    }
}

