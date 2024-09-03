package br.senai.sp.jandira.rick_and_morty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.senai.sp.jandira.rick_and_morty.screens.CharacterDetails
import br.senai.sp.jandira.rick_and_morty.ui.theme.Rick_and_MortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            Rick_and_MortyTheme {
                    CharacterDetails()
                }
            }
        }
    }


