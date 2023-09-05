package com.dgomesdev.mariapolis_rio_2023.domain

import android.content.Context
import android.content.Intent
import android.net.Uri
import javax.inject.Inject

class DialNumberUseCase @Inject constructor (
    private val context: Context
) {
    operator fun invoke(telephoneNumber: String) {
        val number: Uri = Uri.parse("tel:$telephoneNumber")
        val intent = Intent(Intent.ACTION_DIAL, number)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}