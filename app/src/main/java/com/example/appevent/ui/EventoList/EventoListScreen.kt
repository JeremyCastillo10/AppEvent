package com.example.AppEvent.ui.EventoList



import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.AppEvent.data.remote.dto.Eventodto


@Composable
fun EventoListScreen(
    onClick: () -> Unit,
    viewModel: EventoListViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row{
                        Text(text = "Lista")
                        Spacer(Modifier.width(16.dp))
                        androidx.compose.material.Icon(
                            Icons.Filled.Refresh,
                            contentDescription = "refresh",
                            modifier = Modifier

                                .fillMaxSize()
                                .padding(start = 270.dp)
                                .clickable {
                                    viewModel.refresh()

                                }

                        )

                    }

                }

            )


        },

        floatingActionButton = {
            FloatingActionButton(onClick = onClick) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) {

        val uiState by viewModel.uiState.collectAsState()

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(it)) {

            EventoLista(
                evento = uiState.evento,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
        }

    }

}



@Composable
fun EventoLista(
    evento: List<Eventodto>,
    modifier: Modifier = Modifier,
    viewModel: EventoListViewModel = hiltViewModel()
) {

    LazyColumn(modifier = modifier) {
        items(evento) { anonima ->
            EventoRow(anonima,viewModel)
        }
    }
}

@Composable
fun EventoRow(evento: Eventodto, viewModel: EventoListViewModel) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            androidx.compose.material.Icon(
                Icons.Filled.Delete,
                contentDescription = "Fecha",
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable {
                        viewModel.Delete(evento.eventoId)

                    }

            )
            Text(text = "Evento: ${evento.nombreEvento}}",
                style = TextStyle(fontFamily = FontFamily.Default),
                color = Color.White
            )
            Text(text = "Fecha: ${evento.fecha}}",
                style = TextStyle(fontFamily = FontFamily.Default),
                color = Color.White
            )
            Text(text = "Ubicacion: ${evento.ubicacion}}",
                style = TextStyle(fontFamily = FontFamily.Default),
                color = Color.White
            )

            AsyncImage(
                model = "${evento.imagenUrl}",
                contentDescription = null
            )

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                color = Color.LightGray
            )
        }
}



