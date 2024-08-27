package br.senai.sp.jandira.rick_and_morty.model

data class Info(
    val count: Int = 0,
    val pages: Int = 0,
    val next: String =  "https://rickandmortyapi.com/api/character/?page=2",
    val prev: String = ""
)
