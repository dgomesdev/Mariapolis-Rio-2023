package com.dgomesdev.mariapolis_rio_2023.domain

import android.content.Context
import android.content.Intent
import android.net.Uri
import javax.inject.Inject

class OpenLinkUseCase @Inject constructor (
    private val context: Context
) {
    operator fun invoke(url: String) {
        val link: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, link)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}