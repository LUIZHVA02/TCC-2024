package br.senai.sp.jandira.imc.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import imc_calc_vidal.composeapp.generated.resources.Res
import imc_calc_vidal.composeapp.generated.resources.bmi
import org.jetbrains.compose.resources.painterResource

@Composable
fun calculadoraScreen() {
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
                        color = Color(0xcc000000)
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ){
                Image(
                    modifier = Modifier
                        .height(72.dp)
                        .width(72.dp)
                        .background(
                            color = Color(0xcc000000)
                        ),
                    painter = painterResource(Res.drawable.bmi),
                    contentDescription = "",
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop
                )
                Text(
                    modifier = Modifier
                        .background(
                            color = Color(0xcc000000)
                        ),
                    color = Color(0xffffffffff),
                    fontFamily = FontFamily.Default,
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    text = "Calculadora IMC")
            }
            Column {

            }
            Column {

            }
        }
    }
}