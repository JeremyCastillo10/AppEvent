package com.example.AppEvent.ui.Evento

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun EventoScreen(

    onNavigateBack: () -> Unit,
    viewModel: EventoViewModel= hiltViewModel()

) {

    var nameError by remember {
        mutableStateOf(false)
    }

    var ErrorText = if (nameError) "Error: Obligatorio" else " "
    var ErrorColor = if (nameError){
        MaterialTheme.colors.error
    }
    else{
        MaterialTheme.colors.surface.copy(ContentAlpha.medium)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row{
                        Text(text = "Registro de Eventos")
                        Spacer(Modifier.width(16.dp))
                    }
                }
            )

        },

        floatingActionButton = {
            FloatingActionButton(onClick = {
                if(viewModel.nombreEvento.length <=0 || viewModel.ubicacion.length<=0
                    ||viewModel.imagenUrl.length<=0 ||viewModel.categoria.startsWith("0"))
                {
                    nameError = viewModel.nombreEvento.isBlank()
                    nameError = viewModel.ubicacion.isBlank()
                    nameError = viewModel.imagenUrl.isBlank()
                }
                else{
                    viewModel.Save()
                    onNavigateBack()
                }

            }) {
                Icon(imageVector = Icons.Filled.Done, contentDescription = "Add")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp)
        ) {

            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "nombreEvento")},
                value = viewModel.nombreEvento,
                onValueChange = {viewModel.nombreEvento = it})
            if(viewModel.nombreEvento.length <= 0)
            {
                Text(text = ErrorText,
                    color= ErrorColor)

            }
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "ubicacion")},
                value = viewModel.ubicacion,
                onValueChange = {viewModel.ubicacion = it})
            if(viewModel.ubicacion.length <= 0)
            {
                Text(text = ErrorText,
                    color= ErrorColor)

            }
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "imagenUrl")},
                value = viewModel.imagenUrl,
                onValueChange = {viewModel.imagenUrl = it})
            if(viewModel.imagenUrl.length <= 0)
            {
                Text(text = ErrorText,
                    color= ErrorColor)

            }
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "categoria")},
                value = viewModel.categoria,
                onValueChange = {viewModel.categoria = it})
            if(viewModel.categoria.length <= 0)
            {
                Text(text = ErrorText,
                    color= ErrorColor)

            }
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Descripcion")},
                value = viewModel.descripcion,
                onValueChange = {viewModel.descripcion = it})
            if(viewModel.descripcion.length <= 0)
            {
                Text(text = ErrorText,
                    color= ErrorColor)

            }
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "fecha")},
                value = viewModel.fecha,
                onValueChange = {viewModel.fecha = it})
            if(viewModel.fecha.length <= 0)
            {
                Text(text = ErrorText,
                    color= ErrorColor)

            }



        }
    }

}