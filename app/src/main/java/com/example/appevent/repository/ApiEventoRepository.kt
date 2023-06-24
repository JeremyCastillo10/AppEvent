package com.example.AppEvent.repository

import com.example.AppEvent.data.remote.EventoApi
import com.example.AppEvent.data.remote.dto.Eventodto
import javax.inject.Inject

class ApiEventoRepository @Inject constructor(
    val artapi: EventoApi
)
{
    suspend fun GetApiEvento() = artapi.GetList()

    suspend fun PostApiEvento(response: Eventodto) = artapi.InsertarEventoAPI(response)



    suspend fun DeleteApiEvento(Id: Int) = artapi.EliminarEventoAPI(Id)





}