package com.dgomesdev.mariapolis_rio_2023.presentation.fetaures

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dgomesdev.mariapolis_rio_2023.R
import com.dgomesdev.mariapolis_rio_2023.presentation.components.OnCardClick

@Composable
fun EmergencyContacts(
    modifier: Modifier,
    onCardClick: OnCardClick
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Em caso de emergência, clique nos botões para ligar para os numeros",
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )
        Image(
            painter = painterResource(R.drawable.saude),
            contentDescription = "Icone da cruz vermelha",
            modifier = Modifier.height(150.dp)
        )
        InfoCard(
            modifier = modifier
                .fillMaxWidth()
                .clickable {
                    onCardClick(
                        "Call",
                        "21969164987"
                    )
                },
            cardIcon = Icons.Default.Call,
            cardIconDescription = "Simbolo do telefone",
            cardTitle = "Matheus: ",
            cardText = "(21) 96916-4987"
        )
        InfoCard(
            modifier = modifier
                .fillMaxWidth()
                .clickable {
                    onCardClick(
                        "Call",
                        "21997730814"
                    )
                },
            cardIcon = Icons.Default.Call,
            cardIconDescription = "Simbolo do telefone",
            cardTitle = "Maleza: ",
            cardText = "(21) 99773-0814"
        )
        InfoCard(
            modifier = modifier
                .fillMaxWidth()
                .clickable {
                    onCardClick(
                        "Call",
                        "192"
                    )
                },
            cardIcon = Icons.Default.Call,
            cardIconDescription = "Simbolo do telefone",
            cardTitle = "Samu: ",
            cardText = "192"
        )
    }
}