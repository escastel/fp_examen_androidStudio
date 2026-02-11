package com.example.castellanoriosester_examen.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.castellanoriosester_examen.R
import com.example.castellanoriosester_examen.ui.theme.CastellanoRiosEster_ExamenTheme
import com.example.castellanoriosester_examen.viewModel.DBViewModel

//TODO: AÑADIR LOS DATOS DE LOS JUGADORES DE LA BASE DE DATOS y borrar. Recoger todos los jugadores con el viewmodel
@Composable
fun Home(
    onAddClick: () -> Unit,
    viewModel: DBViewModel = viewModel()
) {
    val jugadores by viewModel.jugadores.collectAsState()

    Scaffold(
        topBar = {
            Text(
                text = "Plantilla temporada 25/26",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(16.dp).padding(top = 36.dp)
            )
        },
        bottomBar = {
            Button(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF27D21F) ),
                onClick = onAddClick
            ) {
                Text(
                    text = "Agregar Jugador",
                    fontSize = 20.sp
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            items(jugadores) { item ->
                Card(
                    elevation = CardDefaults.cardElevation(20.dp),
                    modifier = Modifier.padding(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF2FCEE))
                ){
                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ){
                        AsyncImage(
                            model = item.imagen,
                            contentDescription = "Imagen del jugador"
                        )

                        Row(
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxWidth().padding(16.dp)
                        ){
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(64.dp)
                                    .background(Color(0xFF27D21F))
                            ){
                                Text(
                                    text = item.numero.toString(),
                                    color = Color.White,
                                    fontSize = 24.sp
                                )
                            }
                            Column(
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier.height(100.dp)
                            ){
                                Text(
                                    text = item.nombre,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = item.nacionalidad,
                                    fontStyle = FontStyle.Italic
                                )
                                Text(
                                    text = item.posicion
                                )
                            }
                            IconButton( onClick = { viewModel.deleteJugador(item.id) } ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_delete),
                                    contentDescription = ""
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomePreview(){
    CastellanoRiosEster_ExamenTheme {
        Home(
            onAddClick = {}
        )
    }
}