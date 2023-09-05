package com.dgomesdev.mariapolis_rio_2023.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.dgomesdev.mariapolis_rio_2023.presentation.fetaures.EmergencyContacts
import com.dgomesdev.mariapolis_rio_2023.presentation.fetaures.HomeScreen
import com.dgomesdev.mariapolis_rio_2023.presentation.fetaures.Info
import com.dgomesdev.mariapolis_rio_2023.presentation.fetaures.Lyrics
import com.dgomesdev.mariapolis_rio_2023.presentation.fetaures.MariapolisDefinition
import com.dgomesdev.mariapolis_rio_2023.presentation.fetaures.Programme
import com.dgomesdev.mariapolis_rio_2023.presentation.fetaures.TimeOut

@Composable
fun MariapolisNavHost(
    modifier: Modifier,
    navHostController: NavHostController,
    onCardClick: OnCardClick
) {
    val uri = "https://www.example.com"

    val padding = Modifier.padding(8.dp)
    NavHost(
        navController = navHostController,
        startDestination = "Home screen",
        modifier = modifier.padding(8.dp)
    ) {
        composable(route = "Home screen") {
            HomeScreen(
                modifier = padding,
                onCardClick = onCardClick
            )
        }
        composable(route = "Mariapolis definition") {
            MariapolisDefinition(modifier = padding)
        }
        composable(route = "Programme") {
            Programme(modifier = padding)
        }
        composable(route = "Lyrics") {
            Lyrics(modifier = padding)
        }
        composable(route = "Info") {
            Info(
                modifier = padding,
                onCardClick = onCardClick
            )
        }
        composable(route = "Time Out") {
            TimeOut(modifier = padding)
        }
        composable(route = "Emergency contacts") {
            EmergencyContacts(
                modifier = padding,
                onCardClick = onCardClick
            )
        }
    }
}