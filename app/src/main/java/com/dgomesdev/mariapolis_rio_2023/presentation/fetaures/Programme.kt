package com.dgomesdev.mariapolis_rio_2023.presentation.fetaures

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dgomesdev.mariapolis_rio_2023.presentation.components.DaySelectionButtonRow
import com.dgomesdev.mariapolis_rio_2023.presentation.components.OnWeekDaySelection
import com.dgomesdev.mariapolis_rio_2023.presentation.components.dailyProgramme
import com.dgomesdev.mariapolis_rio_2023.presentation.components.dailyTheme
import com.dgomesdev.mariapolis_rio_2023.presentation.theme.selectedButtonColor
import com.dgomesdev.mariapolis_rio_2023.presentation.theme.buttonColor
import com.dgomesdev.mariapolis_rio_2023.presentation.theme.programmeColor

@Composable
fun Programme(
    modifier: Modifier
) {
    var weekDay by rememberSaveable {
        mutableStateOf("07/09")
    }
    Column {
        DaySelectionButtonRow(
            modifier = modifier,
            onWeekDaySelection = { weekDay = it },
            weekDay = weekDay
        )
        if (weekDay != "07/09") Column(
            modifier = modifier.fillMaxWidth().background(programmeColor)
        ) {
            Text(
                "Tema do dia: ${dailyTheme(weekDay).first}",
                modifier = Modifier
                    .border(1.dp, Color.Black)
                    .padding(4.dp)
                    .fillMaxWidth()
            )
            Text(
                "Frase do dia: ${dailyTheme(weekDay).second}",
                modifier = Modifier
                    .border(1.dp, Color.Black)
                    .padding(4.dp)
                    .fillMaxWidth()
            )
        }
        DailyProgramme(
            dailyProgramme = dailyProgramme(weekDay),
            modifier = modifier
        )
    }
}

@Composable
fun DaySelectionButton(
    modifier: Modifier,
    dayButtonText: String,
    onDaySelection: OnWeekDaySelection,
    weekDay: String
) {
    Button(
        onClick = { onDaySelection(dayButtonText) },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            if (weekDay == dayButtonText) selectedButtonColor else buttonColor
        )
        ) {
        Text(dayButtonText, color = Color.White)
    }
}

@Composable
fun DailyProgramme(
    dailyProgramme: Map<String, String>,
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier.border(0.5.dp, Color.Black).background(programmeColor)
    ) {
        for (programmeActivity in dailyProgramme) {
            item {
                Row {
                    Row(
                        modifier = Modifier
                            .border(0.5.dp, Color.Black)
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            programmeActivity.key,
                            modifier = Modifier
                                .padding(8.dp)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .border(0.5.dp, Color.Black)
                            .weight(2f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            programmeActivity.value,
                            modifier = Modifier
                                .padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProgrammePreview() {
    Programme(modifier = Modifier.padding(8.dp))
}