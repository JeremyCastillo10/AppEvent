package com.example.AppEvent.data.remote.dto

data class Asientodto(
    val asientoId: Int,
    val numeroAsiento: String,
    val evento: String,
    val seccion: String,
    val disponibilidad: String,
    val precio: Double,
)