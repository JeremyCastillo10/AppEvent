package com.example.AppEvent.ui.Evento

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.AppEvent.data.remote.dto.Eventodto
import com.example.AppEvent.repository.ApiEventoRepository
import com.example.AppEvent.ui.EventoList.EventoListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class EventoViewModel @Inject constructor(
    val repository: ApiEventoRepository
):ViewModel() {
    var nombreEvento by mutableStateOf("")
    var ubicacion by mutableStateOf("")
    var imagenUrl by mutableStateOf("")
    var categoria by mutableStateOf("")
    var descripcion by mutableStateOf("")
    var fecha by mutableStateOf("")
    private val _uiState = MutableStateFlow(EventoListUiState())
    val uiState: StateFlow<EventoListUiState> = _uiState.asStateFlow()

    fun Save()
    {
        viewModelScope.launch {
            repository.PostApiEvento(
                Eventodto(
                    eventoId = 0,
                    nombreEvento = nombreEvento,
                    ubicacion = ubicacion,
                    imagenUrl = imagenUrl,
                    categoria = categoria,
                    descripcion = descripcion,
                    fecha = fecha,
                )
            )
        }
    }
    fun refresh()
    {
        viewModelScope.launch {
            _uiState.getAndUpdate {
                it.copy(evento = repository.GetApiEvento().sortedBy { it.eventoId })
            }
        }
    }


}