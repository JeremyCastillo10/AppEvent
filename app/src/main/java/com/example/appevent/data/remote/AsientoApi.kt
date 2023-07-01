package com.example.AppEvent.data.remote

import com.example.AppEvent.data.remote.dto.Asientodto
import retrofit2.Response
import retrofit2.http.*

interface AsientoApi {
    @GET("api/Asiento")
    suspend fun GetList(): List<Asientodto>

    @DELETE("api/Asiento/{Id}")
    suspend fun EliminarAsientoAPI(@Path("Id") Id: Int): Response<List<Asientodto>>
}