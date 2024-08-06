package br.senai.sp.jandira.imc

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform