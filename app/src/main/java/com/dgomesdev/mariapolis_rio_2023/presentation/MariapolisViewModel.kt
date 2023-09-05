package com.dgomesdev.mariapolis_rio_2023.presentation

import androidx.lifecycle.ViewModel
import com.dgomesdev.mariapolis_rio_2023.domain.DialNumberUseCase
import com.dgomesdev.mariapolis_rio_2023.domain.OpenLinkUseCase
import com.dgomesdev.mariapolis_rio_2023.domain.SendMailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MariapolisViewModel @Inject constructor(
    private val openLinkUseCase: OpenLinkUseCase,
    private val sendMailUseCase: SendMailUseCase,
    private val dialNumberUseCase: DialNumberUseCase
) : ViewModel() {

    fun intentLauncher(intentType: String, intentData: String) {
        when (intentType) {
            "Mail" -> sendMailUseCase(intentData)
            "Call" -> dialNumberUseCase(intentData)
            else -> openLinkUseCase(intentData)
        }
    }
}