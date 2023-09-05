package com.dgomesdev.mariapolis_rio_2023.presentation.fetaures

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.dgomesdev.mariapolis_rio_2023.R
import com.dgomesdev.mariapolis_rio_2023.presentation.components.MariapolisDefinitionText

@Composable
fun MariapolisDefinition(
    modifier: Modifier
) {
    Column(
        modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "O que é a Mariápolis?",
            modifier = modifier
        )
        Image(
            painter = painterResource(R.drawable.foto_mariapolis),
            contentDescription = "Foto dos participantes da ultima Mariápolis"
        )
        MariapolisDefinitionText(modifier = modifier)
    }
}