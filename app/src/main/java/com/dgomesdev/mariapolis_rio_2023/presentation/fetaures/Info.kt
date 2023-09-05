package com.dgomesdev.mariapolis_rio_2023.presentation.fetaures

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dgomesdev.mariapolis_rio_2023.R
import com.dgomesdev.mariapolis_rio_2023.presentation.components.OnCardClick
import com.dgomesdev.mariapolis_rio_2023.presentation.theme.cardColor
import com.dgomesdev.mariapolis_rio_2023.presentation.theme.notClickableCardColor

@Composable
fun Info(
    modifier: Modifier,
    onCardClick: OnCardClick
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Nossas redes")
        }
        NetworkCard(
            modifier = modifier,
            icon = painterResource(R.drawable.focolare_logo),
            iconDescription = "Logo do Movimento dos Focolares",
            network = "Site do Movimento",
            onCardClick = onCardClick,
            networkLink = "http://focolares.org.br/"
        )
        NetworkCard(
            modifier = modifier,
            icon = painterResource(R.drawable.instagram_logo),
            iconDescription = "Logo do Instagram",
            network = "Instagram",
            onCardClick = onCardClick,
            networkLink = "https://www.instagram.com/focolareriodejaneiro/"
        )
        NetworkCard(
            modifier = modifier,
            icon = painterResource(R.drawable.youtube_icon),
            iconDescription = "Logo do YouTube",
            network = "YouTube",
            onCardClick = onCardClick,
            networkLink = "https://www.youtube.com/channel/UCtSh9V-PJ5G1KHrv-mRKRrA"
        )
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Como chegar")
        }
        InfoCard(
            modifier = modifier
                .fillMaxWidth()
                .clickable {
                    onCardClick(
                        "Map",
                        "geo:0,0?q=-22.605042808548436, -42.751317159716784(Sitio Recanto de Papucaia)"
                    )
                },
            cardIcon = Icons.Default.LocationOn,
            cardIconDescription = "Simbolo do GPS",
            cardTitle = "Local: ",
            cardText = "Sitio Recanto de Papucaia \nAv. Sen. Doutel de Andrade, 2930 \nPapucaia - Cachoeiras de Macau/RJ"
        )
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Contato")
        }
        InfoCard(
            modifier = modifier
                .fillMaxWidth()
                .clickable { onCardClick("Mail", "Informações sobre a Mariápolis") },
            cardIcon = Icons.Default.Email,
            cardIconDescription = "Simbolo do E-mail",
            cardTitle = "E-mail: ",
            cardText = "mariapolisrio2023@gmail.com"
        )
        InfoCard(
            modifier = modifier
                .fillMaxWidth()
                .clickable {
                    onCardClick(
                        "WhatsApp",
                        "http://api.whatsapp.com/send?phone=5521997964723&text=Olá, tudo bem? Eu gostaria de ter mais informações sobre a Mariápolis"
                    )
                },
            cardIcon = ImageVector.vectorResource(R.drawable.whatsapp_logo),
            cardIconDescription = "Logo do WhatsApp",
            cardTitle = "WhatsApp: ",
            cardText = "+55 21 99796-4723"
        )
    }
}

@Composable
fun InfoCard(
    modifier: Modifier,
    cardIcon: ImageVector,
    cardIconDescription: String,
    cardTitle: String,
    cardText: String,
    isClickable: Boolean = true
) {
    val textColor = if (isClickable) Color.Black else Color.White
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            if (isClickable) cardColor else notClickableCardColor
        )
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = cardIcon,
                    contentDescription = cardIconDescription,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 4.dp)
                        .heightIn(1.dp, 20.dp),
                    tint = textColor
                )
                Text(
                    cardTitle,
                    modifier = Modifier.padding(top = 8.dp, start = 4.dp),
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
            }
            Text(
                cardText,
                modifier = Modifier.padding(8.dp),
                color = textColor
            )
        }
    }
}

@Composable
fun NetworkCard(
    modifier: Modifier,
    icon: Painter,
    iconDescription: String,
    network: String,
    onCardClick: OnCardClick,
    networkLink: String
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onCardClick("Link", networkLink) },
        colors = CardDefaults.cardColors(cardColor)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
        ) {
            Image(
                painter = icon,
                contentDescription = iconDescription,
                modifier.height(20.dp)
            )
            Text(network)
        }
    }
}