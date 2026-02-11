package com.example.castellanoriosester_examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.castellanoriosester_examen.navigation.Navigation
import com.example.castellanoriosester_examen.ui.theme.CastellanoRiosEster_ExamenTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        auth = Firebase.auth
        setContent {
            CastellanoRiosEster_ExamenTheme {
                Navigation(auth)
            }
        }
    }
}