package com.example.notesapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao():NoteDao

    companion object{
        private var INSTANCE:NoteDatabase?=null
        fun getDatabase(context: Context):NoteDatabase{
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "notes-database"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}