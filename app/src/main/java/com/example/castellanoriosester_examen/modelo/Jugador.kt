package com.example.castellanoriosester_examen.modelo

import kotlinx.serialization.Serializable

@Serializable
data class Jugador(
    var id: String = "",
    var nombre: String = "",
    var numero: Int = 0,
    var posicion: String = "",
    var nacionalidad: String = "",
    var imagen: String = "",
)