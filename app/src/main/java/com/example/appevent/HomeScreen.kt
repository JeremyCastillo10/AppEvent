package com.example.AppEvent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
@Composable
fun MainScreen(
               onClick1: () -> Unit,
               onClick2: () -> Unit
)
{
    Column() {

        Button(onClick = onClick1) {
            Text(text = "Lista Asientos")

        }
        Button(onClick = onClick2) {
            Text(text = "Lista Eventos")

        }



    }

}