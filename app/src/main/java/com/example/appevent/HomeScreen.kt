package com.example.AppEvent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
@Composable
fun MainScreen(onClick: () -> Unit,
               onClick1: () -> Unit,
)
{
    Column() {
        Button(onClick = onClick) {
            Text(text = "RegistroEventos")

        }
        Button(onClick = onClick1) {
            Text(text = "Lista Eventos")

        }



    }

}