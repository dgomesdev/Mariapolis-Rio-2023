package com.dgomesdev.mariapolis_rio_2023.domain

import android.content.Context
import android.content.Intent
import android.net.Uri
import javax.inject.Inject

class SendMailUseCase @Inject constructor(
    private val context: Context
) {

    operator fun invoke(assunto: String) {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("mariapolisrio2023@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, assunto)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                if (assunto == "Informações sobre a Mariápolis") putExtra(Intent.EXTRA_TEXT, "Olá, tudo bem? Eu gostaria de ter mais informações sobre a Mariápolis")
            }
                context.startActivity(intent)
    }
}