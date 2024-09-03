package br.senai.sp.jandira.rick_and_morty.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.rick_and_morty.model.Character

@Composable
fun CharactersList(modifier: Modifier = Modifier) {
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color(0xffddddddd)
    ){
        Column {
            Text(text = "Rick & Morty API")
            Spacer(modifier = Modifier.height(32.dp))
            LazyColumn {
                items(5){
                    CharacterCard(character = Character())
                }
            }
        }
    }


}

@Composable
fun CharacterCard(character: Character) {
    var characterName by remember {
        mutableStateOf("")
    }
    var characterSpecies by remember {
        mutableStateOf("")
    }

    Card(modifier = Modifier
        .padding(bottom = 4.dp)
        .fillMaxWidth()
        .height(80.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE70F0F))
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
        ){
            Card (
                modifier = Modifier
                    .size(80.dp)
            ) {

            }
            Column (
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp)
            ){
                Text(
                    text = "Nome do Personagem:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Espécie:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun CharactersListPreview() {
    CharactersList()
}