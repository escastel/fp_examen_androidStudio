package com.example.castellanoriosester_examen.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.castellanoriosester_examen.ui.theme.CastellanoRiosEster_ExamenTheme

@Composable
fun Formulario(
    onAddClick: () -> Unit,
    onCancelClick: () -> Unit
) {
    var nombre by remember { mutableStateOf("") }
    var numero by remember { mutableStateOf(0) }
    var posicion by remember { mutableStateOf("") }
    var nacionalidad by remember { mutableStateOf("") }
    var urlImage by remember { mutableStateOf("") }

    Scaffold { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(16.dp).padding(paddingValues)) {
            Text(
                text = "Nuevo Jugador"
            )

            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        text = "Nombre"
                    )
                }
            )

            //TODO: AÑADIR A JUGADOR O VOLVER AL HOME
            Row(){
                Button(onClick = {}) {
                    Text (
                        text = "Agregar Jugador"
                    )
                }
                Button(onClick = {}){
                    Text(
                        text = "Cancelar"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun FormularioPreview(){
    CastellanoRiosEster_ExamenTheme {
        Formulario()
    }
}