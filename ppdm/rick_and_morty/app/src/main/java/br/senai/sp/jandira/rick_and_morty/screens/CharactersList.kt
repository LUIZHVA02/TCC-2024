package br.senai.sp.jandira.rick_and_morty.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.rick_and_morty.model.Character
import br.senai.sp.jandira.rick_and_morty.model.Result
import br.senai.sp.jandira.rick_and_morty.service.RetrofitFactory
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun CharactersList(controleDeNavegacao: NavHostController) {

    var characterList by remember {
        mutableStateOf(listOf<Character>())
    }

    val callCharacterList = RetrofitFactory()
        .getCharacterService()
        .getAllCharacters()

    callCharacterList.enqueue(
        object : Callback<Result>{

            override fun onResponse(
                p0: Call<Result>,
                p1: Response<Result>) {

                characterList = p1.body()!!.results!!
            }

            override fun onFailure(p0: Call<Result>, p1: Throwable) {}
    })

    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color(0xffddddddd)
    ){
        Column {
            Text(text = "Rick & Morty API")
            Spacer(modifier = Modifier.height(32.dp))
            LazyColumn {
                items(characterList){
                    CharacterCard(character = it, controleDeNavegacao = NavHostController(
                        LocalContext.current)
                    )
                }
            }
        }
    }


}

@Composable
fun CharacterCard(character: Character, controleDeNavegacao: NavHostController) {

    var characterName = ""
    var characterSpecies = ""

    characterName = character.name

    characterSpecies = character.species

    Card(
        modifier = Modifier
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
                AsyncImage(
                    model = character.image,
                    contentDescription = "Uma foto do ${character.name}, que faz parte da espécie ${character.species}",
                )
            }
            Column (
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp)
                    .clickable {
                        controleDeNavegacao.navigate("detalhesPersonagem/${character.id}")
                    }
            ){
                Column {
                    Text(
                        text = "Nome do Personagem:",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = characterName,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal
                    )
                }

                Row (modifier = Modifier
                    .width(300.dp)
                ){
                    Text(
                        text = "Espécie:",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = characterSpecies,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal
                    )
                }

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun CharactersListPreview() {
    CharactersList(controleDeNavegacao = NavHostController(LocalContext.current))
}