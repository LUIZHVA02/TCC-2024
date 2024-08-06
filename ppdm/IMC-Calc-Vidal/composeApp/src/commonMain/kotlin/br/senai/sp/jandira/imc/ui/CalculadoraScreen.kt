package br.senai.sp.jandira.imc.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import imc_calc_vidal.composeapp.generated.resources.Res
import imc_calc_vidal.composeapp.generated.resources.bmi
import org.jetbrains.compose.resources.painterResource

@Composable
fun calculadoraScreen() {

    var peso = remember {
        mutableStateOf("")
    }
    var altura = remember {
        mutableStateOf("")
    }
    var showContent = remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize()
    ){
        Column {
            Column (
                modifier = Modifier
                    .padding(10.dp)
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color(0x00000000)
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ){
                Image(
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .background(
                            color = Color(0x00000000)
                        ),
                    painter = painterResource(Res.drawable.bmi),
                    contentDescription = "",
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop
                )
                Text(
                    modifier = Modifier
                        .background(
                            color = Color(0x00000000)
                        ),
                    color = Color(0xff000000),
                    fontFamily = FontFamily.Default,
                    fontSize = 24.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    text = "Calculadora IMC")
            }
            Column (
                modifier = Modifier
                    .padding(10.dp)
                    .height(200.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ){
                OutlinedTextField(
                    value = peso.value,
                    onValueChange = {
                        peso.value = it
                                    },
                    label = {
                        Text("Peso (kg)")
                            },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Spacer(modifier= Modifier.height(8.dp))

                OutlinedTextField(
                    value = altura.value,
                    onValueChange = {
                        altura.value = it
                                    },
                    label = { Text("Altura (cm)") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Button(
                    onClick = {
                        calcularIMC(peso.value, altura.value)
                        showContent = !showContent
                    }
                ){
                    Text(
                        text = "Calcular IMC!"
                    )
                }
            }
            Column {

            }
        }
    }
}

fun calcularIMC(peso: String, altura: String): String{
    val imc = peso.toFloat()/(altura.toFloat()*altura.toFloat())

    return imc.toString()
}