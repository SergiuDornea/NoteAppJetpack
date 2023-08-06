package com.example.noteapp.data

import android.os.Build
import androidx.annotation.RequiresApi

class NoteDataSource {
    @RequiresApi(Build.VERSION_CODES.O)
    fun loadNotes() : List<Note>{
        return  listOf(
            Note(title = "Note 1", note = "Lorem ipsum"),
            Note(title = "Note 2", note = "Lorem ipsum"),
            Note(title = "Note 3", note = "Lorem ipsum"),
            Note(title = "Note 4", note = "Lorem ipsum"),
            Note(title = "Note 5", note = "Lorem ipsum"),
            Note(title = "Note 6", note = "Lorem ipsum"),
            Note(title = "Note 7", note = "Lorem ipsum")
        )
    }
}