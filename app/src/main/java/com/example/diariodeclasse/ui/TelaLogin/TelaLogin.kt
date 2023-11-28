package com.example.diariodeclasse.ui.TelaLogin

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.diariodeclasse.R

@Composable
fun TelaLogin(
    espacoDasBarras:PaddingValues,
    controleNavegacao:NavController
){
    var nome by remember { mutableStateOf("") }
    var login by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }
    var cadastrar by remember { mutableStateOf(false) }
    var logarErro by remember { mutableStateOf(false) }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(espacoDasBarras)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessVeryLow
                    )
                )
        ) {
            if (cadastrar) {
                CampoDeTexto(
                    value = nome,
                    onValueChange = { nome = it },
                    idtexto = R.string.nome,
                    isError = false
                )
            }
            CampoDeTexto(
                value = login,
                onValueChange = { login = it },
                idtexto =   if(logarErro)
                                R.string.login_erro
                            else
                                R.string.login ,
                isError = logarErro
            )
            CampoDeTexto(
                value = senha,
                onValueChange = { senha = it },
                idtexto =   if(logarErro)
                                R.string.senha_erro
                            else
                                R.string.senha ,
                isError = logarErro
            )
            if (cadastrar) {
                CampoDeTexto(
                    value = confirmarSenha,
                    onValueChange = { confirmarSenha = it },
                    idtexto = R.string.confirmarSenha,
                    isError = logarErro
                )
            }
        }
        if (!cadastrar) {
            Text(
                text = "Cadastrar Conta",
                modifier = Modifier.clickable {
                    cadastrar = true
                }
            )
        }
        Spacer(modifier = Modifier.size(10.dp))
        Button(
            onClick = {
                if ( senha == "1234" && login == "rafaelcost@gmail.com") {
                    cadastrar = false
                    logarErro = false
                    controleNavegacao.navigate("TelaDiarioDeClasse")
                }else{
                    logarErro = true
                }
            }
        ) {
            Text(
                text = if (cadastrar)
                    "Cadastrar"
                else
                    "Entrar"
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoDeTexto(
    value: String,
    onValueChange: (String) -> Unit,
    idtexto: Int,
    isError:Boolean
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = stringResource(idtexto)
            )
        },
        isError = isError
    )
}