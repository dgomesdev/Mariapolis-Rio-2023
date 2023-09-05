package com.dgomesdev.mariapolis_rio_2023.presentation.fetaures

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import com.dgomesdev.mariapolis_rio_2023.R
import com.dgomesdev.mariapolis_rio_2023.presentation.components.OnCardClick

@Composable
fun HomeScreen(
    modifier: Modifier,
    onCardClick: OnCardClick
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Seja bem vindo(a) à",
            modifier = modifier
        )
        Image(
            painter = painterResource(R.drawable.mariapolis_banner_rio_2023),
            contentDescription = "Mariapolis",
            modifier = modifier
        )
        Row {
            InfoCard(
                modifier = modifier.weight(0.5f),
                cardIcon = ImageVector.vectorResource(R.drawable.ic_calendar),
                cardIconDescription = "Calendario",
                cardTitle = "Chegada: ",
                cardText = "quinta-feira, 07/09 \n(a partir das 14h)",
                isClickable = false
            )
            InfoCard(
                modifier = modifier.weight(0.5f),
                cardIcon = ImageVector.vectorResource(R.drawable.ic_calendar),
                cardIconDescription = "Calendario",
                cardTitle = "Término: ",
                cardText = "domingo, 10/09 \n(com almoço)",
                isClickable = false
            )
        }
        InfoCard(
            modifier = modifier
                .fillMaxWidth()
                .clickable { onCardClick("Map", "geo:0,0?q=-22.605042808548436, -42.751317159716784(Sitio Recanto de Papucaia)") },
            cardIcon = Icons.Default.LocationOn,
            cardIconDescription = "Simbolo do GPS",
            cardTitle = "Local: ",
            cardText = "Sitio Recanto Papucaia \nAv. Sen. Doutel de Andrade, 2930 \nPapucaia - Cachoeiras de Macau/RJ"
        )
    }
}