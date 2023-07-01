package com.example.AppEvent

import AsientoListScreen
import EventoListScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.AppEvent.util.Screen
import com.example.AppEvent.ui.Evento.EventoScreen
import com.example.AppEvent.ui.theme.AppEventTheme

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppEventTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),

                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen.route
                    ) {
                        composable(Screen.HomeScreen.route) {
                            MainScreen(
                                onClick1 = { navController.navigate(Screen.AsientoListScreen.route) },
                                onClick2 = { navController.navigate(Screen.EventoListScreen.route) },
                            )
                        }
                        composable(Screen.AsientoListScreen.route) {
                            AsientoListScreen(
                                onClick = { navController.navigate(Screen.HomeScreen.route) }
                            )
                        }
                        composable(Screen.EventoListScreen.route) {
                            EventoListScreen(
                                onClick = { navController.navigate(Screen.HomeScreen.route) }
                            )
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppEventTheme {
        Greeting("Android")
    }
}