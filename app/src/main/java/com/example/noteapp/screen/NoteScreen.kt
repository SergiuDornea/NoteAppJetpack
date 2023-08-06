package com.example.noteapp.screen

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.R
import com.example.noteapp.components.InputButton
import com.example.noteapp.components.NoteInputText
import com.example.noteapp.components.NotesDisplay
import com.example.noteapp.data.Note
import com.example.noteapp.data.NoteDataSource

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit,

){
    val context = LocalContext.current
    var title by remember {
        mutableStateOf("")
    }

    var note by remember {
        mutableStateOf("")
    }
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
            NoteInputText(
                text = title,
                label = "Title",
                onTextChange = {
                    if(it.all { c: Char ->
                            c.isLetter() || c.isWhitespace()
                        }) title = it
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            NoteInputText(
                text = note,
                label = "Note",
                onTextChange = {
                    if(it.all { c: Char ->
                            c.isLetter() || c.isWhitespace()
                        }) note = it
                }
            )
            // submit button
            Spacer(modifier = Modifier.height(40.dp))
            InputButton(
                text = "Add note",
                textColor = colorResource(id = R.color.my_mustard) ,
                btnColor =colorResource(id = R.color.my_blue),
                onClick = {
                    if(title.isNotEmpty() && note.isNotEmpty()){
                        // add to the list
                        onAddNote(Note(title = title, note = note))
                        title = ""
                        note = ""
                        Toast.makeText(context, "Memory added", Toast.LENGTH_SHORT).show()
                    }
                }
                )
            // display saved notes
            Divider(
                thickness = 5.dp,
                color = colorResource(id = R.color.my_mustard)
            )
            Divider(
                thickness = 5.dp,
                color = colorResource(id = R.color.my_blue)
            )
            Divider(
                    thickness = 5.dp,
                    color = colorResource(id = R.color.my_mustard)
            )

            // display saved notes
            NotesDisplay(notes = notes, onAddNote = onAddNote, onRemoveNote = onRemoveNote)

        }



    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun NoteScreenPreview(){
    NoteScreen(notes = NoteDataSource().loadNotes(), onAddNote = {}, onRemoveNote ={} )
}