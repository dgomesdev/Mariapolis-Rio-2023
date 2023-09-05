package com.dgomesdev.mariapolis_rio_2023.presentation.fetaures

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dgomesdev.mariapolis_rio_2023.R

@Composable
fun TimeOut(
    modifier: Modifier
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Time Out",
            modifier = modifier,
            fontWeight = FontWeight.Bold
        )
        Image(
            painter = painterResource(R.drawable.timeout),
            contentDescription = "Logo da oraçao Time Out"
        )
        Text(
            "O que é",
            modifier = modifier,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start
        )
        Text(
            stringResource(R.string.timeout_definition),
            modifier = modifier
        )
        Text(
            "A oração",
            modifier = modifier,
            fontWeight = FontWeight.Bold
        )
        Text(
            stringResource(R.string.timout_prayer),
            modifier = modifier,
            textAlign = TextAlign.Start
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TimeOutPreview() {
    TimeOut(Modifier.padding(8.dp))
}