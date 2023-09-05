package com.dgomesdev.mariapolis_rio_2023.presentation.components

fun dailyProgramme(day: String) = when (day) {
    "07/09" -> mapOf(
        "14h" to "Chegada",
        "16h" to "Lanche",
        "16h30" to "Acolhida",
        "17h30" to "Missa",
        "19h" to "Jantar",
        "20h30" to "Dinâmica"
    )
    "08/09" -> mapOf(
        "7h30" to "Café da manha",
        "9h" to "Acolhida",
        "9h30" to "Introdução/Tema",
        "10h10" to "Convivência",
        "11h" to "Música (dança) / Experiências",
        "11h30" to "Temática de forma artistica",
        "12h30" to "Almoço",
        "15h" to "Encontro de grupo",
        "16h" to "Convivência",
        "16h30" to "Mesa",
        "17h30" to "Missa",
        "19h" to "Jantar",
        "20h30" to "Cine Chiara"
    )
    "09/09" -> mapOf(
        "7h30" to "Café da manha",
        "9h" to "Acolhida",
        "9h30" to "Tema / Dinâmica / Experiências",
        "10h10" to "Convivência",
        "11h" to "Missa",
        "11h30" to "Missa",
        "12h30" to "Almoço",
        "15h" to "Gincana - Desafios da comunicação/diálogo com todos",
        "16h30" to "Intervalo",
        "17h20" to "Momento Genfest",
        "17h40" to "Encontro de grupos",
        "19h" to "Jantar",
        "20h30" to "Mariapolital"
    )
    "10/09" -> mapOf(
        "7h30" to "Café da manha",
        "9h" to "Missa",
        "10h" to "Intervalo",
        "10h30" to "Avisos",
        "11h" to "Tema",
        "11h30" to "Experiências",
        "12h30" to "Almoço",
        "14h" to  "Término"
    )
    else -> mapOf()
}

fun dailyTheme(day: String) = when(day) {
    "08/09" -> Pair("O amor...", "Deus Amor, crer no Seu amor, responder ao Seu amor amando, são os grandes imperativos de hoje")
    "09/09" -> Pair("...que se comunica", "Dialogar: uma metodologia de comunicação que nasce do Amor")
    "10/09" -> Pair("Ressureição de Roma", "É preciso  fazer Deus renascer em nós, mantê-Lo vivo e transbordá-Lo para os outros como torrentes de vida")
    else -> Pair("", "")
}