package com.example.noteapp.components

import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.R

@Preview(showBackground = true)
@Composable
fun NoteContainer(
    title: String = "title",
    note: String = "Lorem ipsum",
    date: String = "24.12.2002"
) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.my_blue),
            contentColor = colorResource(id = R.color.my_mustard),
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = title)
                Text(
                    text = date,
                    modifier = Modifier.padding(start = 100.dp)
                )
            }

            Text(
                text = note,

            )
        }
    }
}
