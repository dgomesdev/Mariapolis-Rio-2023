package com.dgomesdev.mariapolis_rio_2023.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dgomesdev.mariapolis_rio_2023.R

@Composable
fun MariapolisDefinitionText(
    modifier: Modifier
) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            stringResource(R.string.mariapolis_definition),
            textAlign = TextAlign.Start
        )
    }
}
