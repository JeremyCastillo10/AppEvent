package com.example.AppEvent.ui.AsientoList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.AppEvent.data.remote.dto.Asientodto
import com.example.AppEvent.repository.ApiAsientoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


data class AsientoListUiState(
    val asiento: List<Asientodto> = emptyList(),
    val texto: String = "Meeting"
)

@HiltViewModel
class AsientoListViewModel @Inject constructor(
    val repository: ApiAsientoRepository

) : ViewModel() {

    private val _uiState = MutableStateFlow(AsientoListUiState())
    val uiState: StateFlow<AsientoListUiState> = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            _uiState.getAndUpdate {
                it.copy(asiento= repository.GetApiAsiento().sortedBy { it.asientoId })
            }
        }

    }

    fun refresh()
    {
        viewModelScope.launch {
            _uiState.getAndUpdate {
                it.copy(asiento = repository.GetApiAsiento().sortedBy { it.asientoId })
            }
        }
    }

    fun Delete(Id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.DeleteApiAsiento(Id)
            _uiState.update {
                it.copy(asiento = repository.GetApiAsiento().sortedBy { it.asientoId })
            }

        }

    }

}
