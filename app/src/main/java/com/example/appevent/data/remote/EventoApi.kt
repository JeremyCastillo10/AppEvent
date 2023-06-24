package com.example.AppEvent.data.remote

import com.example.AppEvent.data.remote.dto.Eventodto
import retrofit2.Response
import retrofit2.http.*

interface EventoApi {
    @GET("api/Evento")
    suspend fun GetList(): List<Eventodto>

    @POST("api/Evento")
    suspend fun InsertarEventoAPI(@Body eventodto: Eventodto): Response<Eventodto>

    @GET("api/Evento/{Id}")
    suspend fun GetEvento(@Path("Id") Id: Int): Response<List<Eventodto>>

    @PUT("api/Evento/{Id}")
    suspend fun UpdateEvento(@Path("Id") Id: Int, @Body eventoResponseDTO: Eventodto): Response<List<Eventodto>>

    @DELETE("api/Evento/{Id}")
    suspend fun EliminarEventoAPI(@Path("Id") Id: Int): Response<List<Eventodto>>
}