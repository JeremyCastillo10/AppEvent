package com.example.AppEvent.util

sealed class Screen(val route: String){
    object EventoListScreen: Screen("EventoLista")
    object EventoScreen: Screen("Evento")
    object AsientoListScreen: Screen("AsientoLista")
    object AsientoScreen: Screen("Asiento")
    object  HomeScreen: Screen("MainScreen")
}