package com.example.castellanoriosester_examen.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.castellanoriosester_examen.R
import com.example.castellanoriosester_examen.ui.theme.CastellanoRiosEster_ExamenTheme

//TODO: AÑADIR LOS DATOS DE LOS JUGADORES DE LA BASE DE DATOS y borrar
@Composable
fun Home(
    onAddClick: () -> Unit
) {
    Scaffold { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues).fillMaxSize().padding(16.dp)){
            Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFF2FCEE))){
                Row(modifier = Modifier.fillMaxWidth()){
                    Box(
                        modifier = Modifier.clip(CircleShape).size(64.dp).background(Color(0xFF27D21F))
                    ){
                        Text(
                            text = "55"
                        )
                    }
                    Column(){
                        Text(
                            text = "Kendrick Perry"
                        )
                        Text("Estados unidos")
                        Text("Base")

                    }
                    IconButton( onClick = {} ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_delete),
                            contentDescription = ""
                        )
                    }
                }
            }
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF27D21F) ),
                onClick = {}
            ) {
                Text(
                    text = "Agregar Jugador",
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun HomePreview(){
    CastellanoRiosEster_ExamenTheme {
        Home()
    }
}