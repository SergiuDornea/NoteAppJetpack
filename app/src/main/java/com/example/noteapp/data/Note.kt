package com.example.noteapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.util.UUID

@RequiresApi(Build.VERSION_CODES.O)
data class Note(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val note: String,
    val entryDate: LocalDateTime = LocalDateTime.now()
)