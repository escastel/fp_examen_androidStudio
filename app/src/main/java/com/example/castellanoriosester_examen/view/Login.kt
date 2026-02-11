package com.example.castellanoriosester_examen.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.castellanoriosester_examen.R
import com.google.firebase.auth.FirebaseAuth

@Composable
fun Login(
    auth: FirebaseAuth,
    onLoginClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isVisiblePassword by remember { mutableStateOf(false)}
    var error by remember { mutableStateOf(false) }

    Scaffold { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
                .fillMaxSize()
        ){
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(180.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Inicia sesión",
                fontSize = 36.sp,

            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                label = {
                    Text(
                        text = "Email"
                    )
                }
            )
            
            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        text = "Contraseña"
                    )
                },
                visualTransformation = if (isVisiblePassword) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    Text(
                        text = "Mostrar",
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .clickable() {
                                isVisiblePassword = !isVisiblePassword
                            }
                    )
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF27D21F) ),
                onClick ={
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnSuccessListener { onLoginClick() }
                        .addOnFailureListener{ error = true }
                }
            ) {
                Text(
                    text = "Login",
                    fontSize = 20.sp
                )
            }

            if (error){
                AlertDialog(
                    title = {
                        Text(text = "Login")
                    },
                    text = {
                        Text(text = "Usuario o contraseña incorrectos")
                    },
                    confirmButton = {
                        Button(onClick = { error = false} ) {
                            Text(text = "Aceptar")
                        }
                    },
                    onDismissRequest = { error = false },

                )
            }
        }
    }
}

//@Preview
//@Composable
//fun LoginPreview(){
//    CastellanoRiosEster_ExamenTheme {
//        Login()
//    }
//}

