package com.example.AppEvent.ui.EventoList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.AppEvent.data.remote.dto.Eventodto
import com.example.AppEvent.repository.ApiEventoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


data class EventoListUiState(
    val evento: List<Eventodto> = emptyList(),
    val texto: String = "Meeting"
)

@HiltViewModel
class EventoListViewModel @Inject constructor(
    val repository: ApiEventoRepository

) : ViewModel() {

    private val _uiState = MutableStateFlow(EventoListUiState())
    val uiState: StateFlow<EventoListUiState> = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            _uiState.getAndUpdate {
                it.copy(evento = repository.GetApiEvento().sortedBy { it.eventoId })
            }
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

    fun Delete(Id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.DeleteApiEvento(Id)
            _uiState.update {
                it.copy(evento = repository.GetApiEvento().sortedBy { it.eventoId })
            }

        }

    }

}
