package com.example.castellanoriosester_examen.viewModel

import androidx.lifecycle.ViewModel
import com.example.castellanoriosester_examen.modelo.Jugador
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.String
import kotlin.collections.mapNotNull
import kotlin.jvm.java

class DBViewModel: ViewModel() {
    private val db = Firebase.firestore
    private val jugadoresCollection = db.collection("Jugadores")

    private val _jugadores = MutableStateFlow<List<Jugador>>(emptyList())
    val jugadores: StateFlow<List<Jugador>> = _jugadores


    init {
        getJugadores()
    }

    private fun getJugadores() {
        jugadoresCollection.addSnapshotListener { snapshot, error ->
            if (error != null) {
                return@addSnapshotListener
            }
            if (snapshot != null) {
                val jugadoresList = snapshot.documents.mapNotNull { doc ->
                    val jugador = doc.toObject(Jugador::class.java)
                    jugador?.id = doc.id
                    jugador
                }
                _jugadores.value = jugadoresList
            }
        }
    }

    fun addJugador(
        nombre: String,
        numero: Int,
        posicion: String,
        nacionalidad: String,
        imagen: String
    ) {
        val jugador = Jugador(
            nombre = nombre,
            numero = numero,
            posicion = posicion,
            nacionalidad = nacionalidad,
            imagen = imagen
        )

        jugadoresCollection.add(jugador)
            .addOnFailureListener {}
            .addOnSuccessListener {}
            .addOnCompleteListener {}
    }

    fun deleteJugador(id: String) {
        jugadoresCollection.document(id)
            .delete()
            .addOnFailureListener {}
            .addOnFailureListener {}
    }
}