package com.example.diariodeclasse.model

data class Aluno(
    val nome:String,
    val curso:String,
    var notas:Int = 0,
    var faltas:Int = 0,
    var imagem:Int
)
