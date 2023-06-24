package com.example.AppEvent.util

sealed class Screen(val route: String){
    object EventoListScreen: Screen("EventoLista")
    object EventoScreen: Screen("Evento")
    object  HomeScreen: Screen("MainScreen")
}