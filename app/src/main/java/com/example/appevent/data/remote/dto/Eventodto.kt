package com.example.AppEvent.data.remote.dto

data class Eventodto(
    val eventoId: Int,
    val nombreEvento: String,
    val ubicacion: String,
    val imagenUrl: String,
    val categoria: String,
    val descripcion: String,
    val fecha: String
)