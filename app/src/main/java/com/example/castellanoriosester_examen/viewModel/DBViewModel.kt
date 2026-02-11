package com.example.castellanoriosester_examen.viewModel

import androidx.lifecycle.ViewModel
import com.example.castellanoriosester_examen.modelo.Jugador
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DBViewModel: ViewModel() {
    private val _juagdores = MutableStateFlow<List<Jugador>>(emptyList())
    val nombreLista: StateFlow<List<Jugador>> = _juagdores
}