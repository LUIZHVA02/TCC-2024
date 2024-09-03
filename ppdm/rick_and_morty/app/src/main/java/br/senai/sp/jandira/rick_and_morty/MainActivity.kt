package br.senai.sp.jandira.rick_and_morty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.rick_and_morty.model.Character
import br.senai.sp.jandira.rick_and_morty.screens.CharacterDetails
import br.senai.sp.jandira.rick_and_morty.screens.CharactersList
import br.senai.sp.jandira.rick_and_morty.ui.theme.Rick_and_MortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            Rick_and_MortyTheme {
                val controleDeNavegacao = rememberNavController()
                NavHost(
                    navController = controleDeNavegacao,
                    startDestination = "ListaPersonagem"
                ){
                    composable(route = "ListaPersonagens"){ CharactersList(controleDeNavegacao) }
                    composable(route = "DetalhesPersonagem"){ CharacterDetails(character = Character(), controleDeNavegacao) }
                }
                }
            }
        }
    }


