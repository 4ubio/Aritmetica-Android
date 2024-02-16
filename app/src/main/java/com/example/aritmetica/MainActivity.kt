package com.example.aritmetica

import android.os.Bundle
import android.text.TextUtils
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aritmetica.ui.theme.AritmeticaTheme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AritmeticaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtimeticScreen()
                }
            }
        }
    }
}

fun checkWroteNumber(text: String): Int {
    if (text.toIntOrNull() != null) {
        return text.toInt()
    } else if (TextUtils.isEmpty(text)) {
        return 0
    }
    return 1
}

//Calc functions
fun sum(numberOne: Int, numberTwo:Int): String {
    return "El resultado de la suma es: " + (numberOne + numberTwo).toString()
}

fun minus(numberOne: Int, numberTwo:Int): String {
    return "El resultado de la resta es: " + (numberOne - numberTwo).toString()
}

fun mul(numberOne: Int, numberTwo:Int): String {
    return "El resultado de la multiplicación es: " + (numberOne * numberTwo).toString()
}

fun div(numberOne: Int, numberTwo:Int): String {
    val result = numberOne.toDouble() / numberTwo.toDouble()
    return "El resultado de la división es: " + String.format("%.2f", result)
}

@Composable
fun ArtimeticScreen() {
    var numberOne: Int by remember { mutableStateOf(0) }
    var numberTwo: Int by remember { mutableStateOf(0) }
    var result: String by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Calculadora",
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = numberOne.toString(),
            onValueChange = {numberOne = checkWroteNumber(it)},
            label = {
                Text(text = "Escribe un número")
            },
            placeholder = {
                Text(text = "Por favor, escribe un número")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Star, contentDescription = "Icon")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        )
        
        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = numberTwo.toString(),
            onValueChange = {numberTwo = checkWroteNumber(it)},
            label = {
                Text(text = "Escribe un número")
            },
            placeholder = {
                Text(text = "Por favor, escribe un número")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Star, contentDescription = "Icon")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        //Suma
        Button(
            onClick = {result = sum(numberOne, numberTwo)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Text(text = "Sumar")
        }

        //Resta
        Button(
            onClick = {result = minus(numberOne, numberTwo)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Text(text = "Restar")
        }

        //Multiplicación
        Button(
            onClick = {result = mul(numberOne, numberTwo)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Text(text = "Multiplicar")
        }

        //División
        Button(
            onClick = {result = div(numberOne, numberTwo)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Text(text = "Dividir")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = result,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArtimeticPreview() {
    AritmeticaTheme {
        ArtimeticScreen()
    }
}