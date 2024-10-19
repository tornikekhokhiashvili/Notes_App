package com.example.notesapp.Data.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notesapp.Data.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}