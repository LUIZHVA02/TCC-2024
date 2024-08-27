package br.senai.sp.jandira.rick_and_morty.service

import br.senai.sp.jandira.rick_and_morty.model.Character
import br.senai.sp.jandira.rick_and_morty.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {



    @GET("/character")
    fun getAllCharacters(): Call<Result>

    @GET("/character/{id}")
    fun getCharacterById(@Path("id") id: Int): Call<Character>

//    @GET
//    fun get
}