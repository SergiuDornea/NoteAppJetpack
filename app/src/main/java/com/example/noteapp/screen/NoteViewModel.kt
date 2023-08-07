package com.example.noteapp.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.noteapp.data.Note
import com.example.noteapp.data.NoteDataSource

@RequiresApi(Build.VERSION_CODES.O)
class NoteViewModel : ViewModel() {
    private var noteList = mutableStateListOf<Note>()

    init{
        noteList.addAll(NoteDataSource().loadNotes())
    }
    fun addNote(note: Note){
        noteList.add(note)
    }

    fun removeNote(note:Note){
        noteList.remove(note)
    }

    fun getAllNotes() : List<Note>{
        return noteList
    }
}
