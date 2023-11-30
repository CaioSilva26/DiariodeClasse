package com.example.diariodeclasse.ui.TelaDiariodeClasse

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.diariodeclasse.R
import com.example.diariodeclasse.data.BDAlunos
import com.example.diariodeclasse.model.Aluno

@Composable
fun TelaDiarioDeClasse(
    espacoDasBarras: PaddingValues,
    controleNavegacao: NavController
){
    Column(
        modifier = Modifier
            .padding(espacoDasBarras)
    ) {

    }
}

@Composable
fun ListaAlunos(listaAlunos:List<Aluno>){
    LazyColumn{
        items(listaAlunos) {
            aluno ->
                CardAluno(aluno)
        }
    }
}

@Composable
fun CardAluno(
    aluno: Aluno
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column {
            Row {
                Image(
                    painter = painterResource(id = aluno.imagem),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
                Column {
                    Text(
                        text =aluno.nome
                    )
                    Text(
                        text =aluno.curso
                    )
                }
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = null
                )
            }
            Column {
                Text(
                    text = "${aluno.notas}"
                )
                Text(
                    text = "${aluno.faltas}"
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewListaAlunos(){
    ListaAlunos(
        listaAlunos = BDAlunos().carregaListaAlunos()
    )
}