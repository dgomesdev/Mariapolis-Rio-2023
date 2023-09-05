package com.dgomesdev.mariapolis_rio_2023.presentation.fetaures

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dgomesdev.mariapolis_rio_2023.R

@Composable
fun Lyrics(
    modifier: Modifier
) {
    Column(
        Modifier.verticalScroll(rememberScrollState())
    ) {
        Song(
            modifier = modifier,
            songName = "Quem",
            songLyrics = stringResource(R.string.quem)
        )
        Song(
            modifier = modifier,
            songName = "É tão linda a vida",
            songLyrics = stringResource(R.string.e_tao_linda_a_vida)
        )
        Song(
            modifier = modifier,
            songName = "Permanece conosco",
            songLyrics = stringResource(R.string.permanece_conosco)
        )
        Song(
            modifier = modifier,
            songName = "E uma estrada se abre",
            songLyrics = stringResource(R.string.e_uma_estrada_se_abre)
        )
        Song(
            modifier = modifier,
            songName = "Em direção ao sol",
            songLyrics = stringResource(R.string.em_direcao_ao_sol)
        )
        Song(
            modifier = modifier,
            songName = "Um rio de felicidade",
            songLyrics = stringResource(R.string.um_rio_de_felicidade)
        )
        Song(
            modifier = modifier,
            songName = "O teu amor está em mim",
            songLyrics = stringResource(R.string.o_teu_amor_esta_em_mim)
        )
        Song(
            modifier = modifier,
            songName = "É grande",
            songLyrics = stringResource(R.string.e_grande)
        )
        Song(
            modifier = modifier,
            songName = "E a terra será",
            songLyrics = stringResource(R.string.e_a_terra_sera)
        )
        Song(
            modifier = modifier,
            songName = "Toda vida é um dom",
            songLyrics = stringResource(R.string.toda_vida_e_um_dom)
        )
        Song(
            modifier = modifier,
            songName = "Ideal que história se faz",
            songLyrics = stringResource(R.string.ideal_que_historia_se_faz)
        )
        Song(
            modifier = modifier,
            songName = "Viver para amar",
            songLyrics = stringResource(R.string.viver_para_amar)
        )
        Song(
            modifier = modifier,
            songName = "Trem",
            songLyrics = stringResource(R.string.trem)
        )
        Song(
            modifier = modifier,
            songName = "Estrada segura",
            songLyrics = stringResource(R.string.estrada_segura)
        )
        Song(
            modifier = modifier,
            songName = "Vós sois só de Deus",
            songLyrics = stringResource(R.string.vos_sois_so_de_Deus)
        )
    }
}

@Composable
fun Song(
    modifier: Modifier,
    songName: String,
    songLyrics: String
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(songName, modifier = modifier.weight(3f), color = Color.Black)
            IconButton(onClick = { expanded = !expanded }, modifier = modifier.weight(1f)) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = if (expanded) "show less"
                    else "show more"
                )
            }
        }
        if (expanded) {
            Column(modifier = modifier.padding(8.dp)) {
                Text(songLyrics, color = Color.Black, textAlign = TextAlign.Start)
            }
        }
    }
}