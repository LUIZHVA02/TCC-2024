package br.senai.sp.jandira.rick_and_morty.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.rick_and_morty.model.Character
import br.senai.sp.jandira.rick_and_morty.service.RetrofitFactory
import br.senai.sp.jandira.rick_and_morty.ui.theme.Rick_and_MortyTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun CharacterDetails(id: String?, controleDeNavegacao: NavHostController) {

    val id = id ?: "0"

    var character by remember {
        mutableStateOf(Character())
    }

    Surface (
        modifier = Modifier
            .fillMaxSize()
    ){
        Column (
            modifier = Modifier
                .padding(8.dp)
        ){
            val callCharacter = RetrofitFactory()
                .getCharacterService()
                .getCharacterById(id.toInt())

            callCharacter.enqueue(object : Callback<Character> {
                override fun onResponse(p0: Call<Character>, response: Response<Character>) {
                    if (response.isSuccessful){
                        character = response.body()!!

                    }
                }
                override fun onFailure(p0: Call<Character>, p1: Throwable) {
                }
            })

            Text(text = "ID: ${character.id}")
            Text(text = "Nome: ${character.name}")
            Text(text = "Status: ${character.status}")
            Text(text = "Espécie: ${character.species}")
            Text(text = "Origem: ${character.origin?.name}")
            Text(text = "Localização: ${character.location?.name}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterDetailsPreview() { 
    Rick_and_MortyTheme {
        CharacterDetails(id = "1", controleDeNavegacao = NavHostController(LocalContext.current))
    }
}