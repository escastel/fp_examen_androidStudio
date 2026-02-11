package com.example.castellanoriosester_examen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.castellanoriosester_examen.view.Formulario
import com.example.castellanoriosester_examen.view.Home
import com.example.castellanoriosester_examen.view.Login
import com.google.firebase.auth.FirebaseAuth

@Composable
fun Navigation(auth: FirebaseAuth) {
    val backStack = rememberNavBackStack(Routes.Login)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is Routes.Login -> NavEntry(key) {
                    Login(
                        auth = auth,
                        onLoginClick = { backStack.add(Routes.Home) },
                    )
                }
                is Routes.Home -> NavEntry(key) {
                    Home(
                        onAddClick = { backStack.add(Routes.Formulario)}
                    )
                }
                is Routes.Formulario -> NavEntry(key) {
                    Formulario(
                        onAddClick = { backStack.removeLastOrNull()},
                        onCancelClick = { backStack.removeLastOrNull()},
                    )
                }
                else -> NavEntry(key = Routes.Error){}
            }
        },
    )
}