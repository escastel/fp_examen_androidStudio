package com.example.castellanoriosester_examen.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.castellanoriosester_examen.ui.theme.CastellanoRiosEster_ExamenTheme
import com.example.castellanoriosester_examen.viewModel.DBViewModel

@Composable
fun Formulario(
    onAddClick: () -> Unit,
    onCancelClick: () -> Unit,
    viewModel: DBViewModel = viewModel()
) {
    var nombre by remember { mutableStateOf("") }
    var numero by remember { mutableStateOf("") }
    var posicion by remember { mutableStateOf("") }
    var nacionalidad by remember { mutableStateOf("") }
    var imagen by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            Text(
                text = "Nuevo Jugador",
                fontSize = 30.sp,
                modifier = Modifier.fillMaxWidth().padding(16.dp).padding(top = 36.dp),
                fontWeight = FontWeight.Bold
            )
        }
    ) { paddingValues ->
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(paddingValues)
        ) {
            TextField(
                value = nombre,
                onValueChange = { nombre = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        text = "Nombre"
                    )
                }
            )
            TextField(
                value = numero,
                onValueChange = { numero = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        text = "Numero"
                    )
                }
            )
            TextField(
                value = posicion,
                onValueChange = { posicion = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        text = "Posición"
                    )
                }
            )
            TextField(
                value = nacionalidad,
                onValueChange = { nacionalidad = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        text = "Nacionalidad"
                    )
                }
            )
            TextField(
                value = imagen,
                onValueChange = { imagen = it },
                modifier = Modifier.fillMaxWidth().height(100.dp),
                label = {
                    Text(
                        text = "URL Imagen"
                    )
                }
            )

            //TODO: AÑADIR A JUGADOR O VOLVER AL HOME
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ){
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF27D21F)),
                    onClick = {
                        viewModel.addJugador(
                            nombre,
                            numero.toInt(),
                            posicion,
                            nacionalidad,
                            imagen
                        )
                        onAddClick()
                        nombre = ""
                        numero = ""
                        posicion = ""
                        nacionalidad = ""
                        imagen = "" }
                ) {
                    Text (
                        text = "Agregar Jugador"
                    )
                }
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    onClick = onCancelClick
                ){
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
        Formulario(
            onAddClick = {},
            onCancelClick = {}
        )
    }
}