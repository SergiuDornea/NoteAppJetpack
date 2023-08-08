package com.example.noteapp.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.noteapp.data.Note

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotesDisplay(
    notes: List<Note>,
    onRemoveNote: (Note) -> Unit,

    )
{
    LazyColumn{
        items(notes){note->
            NoteContainer(
                note = note,
                onNoteclick = {
                    onRemoveNote(note)
                }
            )
        }
    }
}