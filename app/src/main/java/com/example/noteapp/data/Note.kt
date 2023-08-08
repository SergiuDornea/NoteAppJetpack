package com.example.noteapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.noteapp.util.getDateAsString
import com.example.noteapp.util.getIdAsString
import java.time.Instant
import java.util.Date
import java.util.UUID

@Entity(tableName = "notes_tbl")
@RequiresApi(Build.VERSION_CODES.O)
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
//    val id : String = getIdAsString(),
    @ColumnInfo(name = "Note_title")
    val title: String,
    @ColumnInfo(name = "note_description")
    val note: String,
    @ColumnInfo(name = "note_entry_date")
//    val entryDate: Date = Date.from(Instant.now())
    val entryDate : String = getDateAsString(),
)