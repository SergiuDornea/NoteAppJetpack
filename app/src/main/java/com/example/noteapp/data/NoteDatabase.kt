package com.example.noteapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.noteapp.util.DateConverter
import com.example.noteapp.util.IdConverter
import java.util.UUID

@RequiresApi(Build.VERSION_CODES.O)
@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(IdConverter::class)
abstract class NoteDatabase : RoomDatabase()  {
    abstract fun noteDao(): NoteDatabaseDao

}