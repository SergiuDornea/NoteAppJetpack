package com.example.noteapp.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.noteapp.data.Note

@Composable
fun NotesDisplay(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
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