package com.dgomesdev.mariapolis_rio_2023.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.dgomesdev.mariapolis_rio_2023.R
import com.dgomesdev.mariapolis_rio_2023.presentation.theme.backgroundColor
import com.dgomesdev.mariapolis_rio_2023.presentation.theme.barColor
import kotlinx.coroutines.launch

typealias OnScreenChange = (String) -> Unit
typealias OnCardClick = (String, String) -> Unit

@Composable
fun MariapolisApp(
    onCardClick: OnCardClick,
    intentScreen: String?
) {
    val navController = rememberNavController()
    if (intentScreen != null) navController.navigate(intentScreen)

    val scaffoldState = rememberScaffoldState()
    var section  by rememberSaveable {
        mutableStateOf(Pair("Home screen", "Inicio"))
    }
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier,
        scaffoldState = scaffoldState,
        topBar = {
            MariapolisTopBar(
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                },
                onCardClick = onCardClick,
                onScreenChange = { navController.navigate(it) }
            )
                 },
        bottomBar = {
            MariapolisBottomBar(
            onScreenChange = { navController.navigate(it) },
            currentSection = section
        )
                    },
        drawerContent = {
            Sections(
                onExpandChange = {
                                 scope.launch {
                                     scaffoldState.drawerState.close()
                                 }
                                 },
                onScreenChange = { navController.navigate(it) } ,
                onSectionChange = { section = it },
                onCardClick = onCardClick
            )
        },
        backgroundColor = backgroundColor
    ) {
        MariapolisNavHost(
            modifier = Modifier.padding(it),
            navHostController = navController,
            onCardClick = onCardClick
        )
    }
}

@Composable
fun MariapolisTopBar(
    onNavigationIconClick: () -> Unit,
    onCardClick: OnCardClick,
    onScreenChange: OnScreenChange
) {
    var expandedMenu by remember {
        mutableStateOf(false)
    }
    TopAppBar(
        title = { Text(
            stringResource(R.string.app_name),
            color = Color.White
        ) },
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu principal",
                    tint = Color.White
                    )
            }
        },
        actions = {
            IconButton(onClick = { expandedMenu = !expandedMenu }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Opções",
                    tint = Color.White
                )
                OptionsMenu(
                    expandedMenu = expandedMenu,
                    onExpandChange = { expandedMenu = !expandedMenu },
                    onCardClick = onCardClick,
                    onScreenChange = onScreenChange
                    )
            }
        },
        backgroundColor = barColor
    )
}

@Composable
fun OptionsMenu(
    expandedMenu: Boolean,
    onExpandChange: () -> Unit,
    onCardClick: OnCardClick,
    onScreenChange: OnScreenChange
) {
    DropdownMenu(
        expanded = expandedMenu,
        onDismissRequest = { onExpandChange() }
    ) {
        DropdownMenuItem(
            text = { Text("Contatos de emergência") },
            onClick = { onExpandChange() ; onScreenChange("Emergency contacts") }
        )
    DropdownMenuItem(
            text = { Text("Como chegar") },
            onClick = { onExpandChange() ; onCardClick("Map", "geo:0,0?q=-22.605042808548436, -42.751317159716784(Sitio Recanto de Papucaia)")}
        )
    DropdownMenuItem(
            text = { Text("Compartihe sua impressão") },
            onClick = { onExpandChange() ; onCardClick("Mail", "Impressões sobre a Mariápolis") }
        )
    }
}

@Composable
fun Sections(
    onExpandChange: () -> Unit,
    onScreenChange: OnScreenChange,
    onSectionChange: (Pair<String, String>) -> Unit,
    onCardClick: OnCardClick
) {
    val sections = mapOf(
        "Home screen" to "Início",
        "Mariapolis definition" to "O que é a Mariápolis",
        "Programme" to "Programação",
        "Lyrics" to "Músicas",
        "Time Out" to "Time Out"
    )
    Column {
        Image(
            painter = painterResource(R.drawable.mariapolis_logo),
            contentDescription = ""
        )
        Column(
            modifier = Modifier.border(1.dp, Color.Black)
        ) {
            for (section in sections) {
                val screen = Pair(section.key, section.value)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(0.5.dp, Color.Black)
                ) {
                    Text(
                        section.value,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable {
                                onExpandChange()
                                onScreenChange(section.key)
                                onSectionChange(screen)
                            }
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                "Desenvolvido por Danilo Gomes",
                modifier = Modifier.clickable {
                onCardClick("Link", "https://wwww.dgomesdev.com")
            }
            )
            Text("https://wwww.dgomesdev.com",
                modifier = Modifier.clickable {
                onCardClick("Link", "https://wwww.dgomesdev.com")
            }
            )
        }
    }
}

@Composable
fun MariapolisBottomBar(
    onScreenChange: OnScreenChange,
    currentSection: Pair<String, String>
    ) {
        var currentScreen by remember {
            mutableIntStateOf(0)
        }
        val tabs = listOf(currentSection.first, "Info")
        NavigationBar(
            containerColor = barColor
        ) {
            tabs.forEachIndexed{ index, tab ->
                NavigationBarItem(
                    selected = currentScreen == index,
                    onClick = { onScreenChange(tab); currentScreen = index },
                    icon = {
                        if (index == 0) Icon(imageVector = Icons.Default.Home, contentDescription = "Tela principal", tint = Color.White)
                        else Icon(imageVector = Icons.Default.Info, contentDescription = "Tela de mais informações", tint = Color.White)
                    },
                    label = {
                        Text(
                            text = if (index == 0) "Tela principal"
                            else "Mais informações",
                            color = Color.White
                        )
                    }
                )
            }
        }
}