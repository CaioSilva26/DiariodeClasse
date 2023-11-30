package com.example.diariodeclasse.data

import com.example.diariodeclasse.R
import com.example.diariodeclasse.model.Aluno

class BDAlunos {
    fun carregaListaAlunos():List<Aluno>{
        return listOf<Aluno>(
            Aluno("Rafael Costa","Eletrônica", imagem = R.drawable.moca),
            Aluno("aluno2","Eletrônica", imagem = R.drawable.moca),
            Aluno("aluno3","adgv", imagem = R.drawable.moca),
            Aluno("aluno4","Eletrôzfgsdfgnica", imagem = R.drawable.moca),
            Aluno("aluno5","Eletrsvdgsgônica", imagem = R.drawable.moca),
            Aluno("aluno6","sdvgsdgvsd", imagem = R.drawable.moca),
            Aluno("aluno7","sdvgvd", imagem = R.drawable.moca),
            Aluno("aluno8","svgsdgvsdfg", imagem = R.drawable.moca),
        )
    }

}