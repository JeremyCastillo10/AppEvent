package com.example.AppEvent.repository
import com.example.AppEvent.data.remote.AsientoApi
import javax.inject.Inject

class ApiAsientoRepository @Inject constructor(
    val artapi: AsientoApi
)
{
    suspend fun GetApiAsiento() = artapi.GetList()

    suspend fun DeleteApiAsiento(Id: Int) = artapi.EliminarAsientoAPI(Id)





}