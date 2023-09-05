package com.dgomesdev.mariapolis_rio_2023.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.dgomesdev.mariapolis_rio_2023.notifications.NotificationWorker
import com.dgomesdev.mariapolis_rio_2023.presentation.components.MariapolisApp
import com.dgomesdev.mariapolis_rio_2023.presentation.theme.MariapolisRio2023Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mariapolisViewModel by viewModels<MariapolisViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableNotifications()
        Log.d("SCREEN", "Screen: $screen")
        setContent {
            MariapolisRio2023Theme {
                MariapolisApp(
                    mariapolisViewModel::intentLauncher,
                    screen
                )
            }
        }
    }

    private fun enableNotifications() {

        NotificationWorker.enableProgrammeBeginningNotification(
            this,
            "Deus Amor, crer no Seu amor, responder ao Seu amor amando, sao os grandes imperativos de hoje",
            4
        )

        NotificationWorker.enableProgrammeBeginningNotification(
            this,
            "Deus Amor, crer no Seu amor, responder ao Seu amor amando, sao os grandes imperativos de hoje",
            8
        )
        NotificationWorker.enableProgrammeBeginningNotification(
            this,
            "Dialogar: uma metodologia de comunicação que nasce do Amor",
            9
        )
        NotificationWorker.enableProgrammeBeginningNotification(
            this,
            "É preciso  fazer Deus renascer em nós, mantê-Lo vivo e transbordá-Lo para os outros como torrentes de vida",
            10
        )
        NotificationWorker.enableTimeOutNotification(
            this,
            8
        )
    NotificationWorker.enableTimeOutNotification(
            this,
            9
        )
    NotificationWorker.enableTimeOutNotification(
            this,
            10
        )
    }

    companion object {
        var screen: String? = null
    }
}