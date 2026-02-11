package com.example.castellanoriosester_examen.viewModel

import androidx.lifecycle.ViewModel
import com.example.castellanoriosester_examen.modelo.Jugador
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.String
import kotlin.collections.mapNotNull
import kotlin.collections.set
import kotlin.jvm.java
import kotlin.text.isNotBlank
import kotlin.text.toDouble

class DBViewModel: ViewModel() {
    private val db = Firebase.firestore
    private val jugadoresCollection = db.collection("Jugadores")

    private val _Jugadores = MutableStateFlow<List<Jugador>>(emptyList())
    val jugadores: StateFlow<List<Jugador>> = _Jugadores


    init {
        getJugadores()
    }

    private fun getJugadores() {
        jugadoresCollection.addSnapshotListener { snapshot, error ->
            if (error != null) {
                return@addSnapshotListener
            }
            if (snapshot != null) {
                val JugadoresList = snapshot.documents.mapNotNull { doc ->
                    val jugador = doc.toObject(Jugador::class.java)
                    jugador?.id = doc.id
                    jugador
                }
                _Jugadores.value = JugadoresList
            }
        }
    }

    fun addJugador(nombre: String, numero: Int, posicion: String, nacionalidad: String, imagen: String) {
        val Jugador = Jugador(
            nombre = nombre,
            numero = numero,
            posicion = posicion,
            nacionalidad = nacionalidad,
            imagen = imagen
        )

        jugadoresCollection.add(Jugador)
            .addOnFailureListener {}
            .addOnSuccessListener { }
            .addOnCompleteListener { }
    }

    fun deleteJugador(id: String) {
        jugadoresCollection.document(id)
            .delete()
            .addOnFailureListener {}
            .addOnFailureListener {}
    }

    fun updateJugador(id: String, nombre: String, numero: String, posicion: String, nacionalidad: String, imagen: String) {
        val data = mutableMapOf<String, Any>()

        if (nombre.isNotBlank()) {
            data["nombre"] = nombre
        }
        if (numero.isNotBlank()) {
            data["numero"] = numero.toDouble()
        }
        if (posicion.isNotBlank()) {
            data["posicion"] = posicion
        }
        if (nacionalidad.isNotBlank()) {
            data["nacionalidad"] = nacionalidad
        }
        if (imagen.isNotBlank()) {
            data["imagen"] = imagen
        }

        jugadoresCollection.document(id)
            .update(data)
            .addOnSuccessListener {}
            .addOnFailureListener {}
    }
}