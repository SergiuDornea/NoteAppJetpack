package com.example.noteapp.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.R
import com.example.noteapp.components.InputButton
import com.example.noteapp.components.NoteInputText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = colorResource(id = R.color.my_blue),
                titleContentColor = colorResource(id = R.color.my_mustard)
            )

        )

        //Content
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 30.dp)
        ) {
            // insert input fields
            NoteInputText(text = "Hello", label = "Title", onTextChange = {})
            Spacer(modifier = Modifier.height(20.dp))
            NoteInputText(text = "Your note", label = "Note", onTextChange = {})
            // submit button
            Spacer(modifier = Modifier.height(40.dp))
            InputButton(text = "Add note", textColor = colorResource(id = R.color.my_mustard) , btnColor =colorResource(id = R.color.my_blue))
            // display saved notes
        }



    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview(){
    NoteScreen()
}