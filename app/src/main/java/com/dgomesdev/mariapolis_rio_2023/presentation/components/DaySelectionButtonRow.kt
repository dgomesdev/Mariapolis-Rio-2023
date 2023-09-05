package com.dgomesdev.mariapolis_rio_2023.presentation.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dgomesdev.mariapolis_rio_2023.presentation.fetaures.DaySelectionButton

typealias OnWeekDaySelection = (String) -> Unit

@Composable
fun DaySelectionButtonRow(
    modifier: Modifier,
    onWeekDaySelection: OnWeekDaySelection,
    weekDay: String
) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState())
    ) {
        DaySelectionButton(
            modifier = Modifier.padding(horizontal = 4.dp),
            dayButtonText = "07/09",
            onDaySelection = onWeekDaySelection,
            weekDay = weekDay
        )
        DaySelectionButton(
            modifier = Modifier.padding(horizontal = 4.dp),
            dayButtonText = "08/09",
            onDaySelection = onWeekDaySelection,
            weekDay = weekDay
        )
        DaySelectionButton(
            modifier = Modifier.padding(horizontal = 4.dp),
            dayButtonText = "09/09",
            onDaySelection = onWeekDaySelection,
            weekDay = weekDay
        )
        DaySelectionButton(
            modifier = Modifier.padding(horizontal = 4.dp),
            dayButtonText = "10/09",
            onDaySelection = onWeekDaySelection,
            weekDay = weekDay
        )
    }
}