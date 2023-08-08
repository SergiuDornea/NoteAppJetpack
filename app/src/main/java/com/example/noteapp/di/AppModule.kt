package com.example.noteapp.di

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Room
import com.example.noteapp.data.NoteDatabase
import com.example.noteapp.data.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class  )
@Module
object AppModule {
    @RequiresApi(Build.VERSION_CODES.O)
    @Singleton
    @Provides
    fun provideNotesDao(noteDatabase: NoteDatabase) : NoteDatabaseDao
    = noteDatabase.noteDao()

    @RequiresApi(Build.VERSION_CODES.O)
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) : NoteDatabase
    = Room.databaseBuilder(
        context = context,
        NoteDatabase::class.java,
        name = "notes_db"
        ).fallbackToDestructiveMigration().build()
}