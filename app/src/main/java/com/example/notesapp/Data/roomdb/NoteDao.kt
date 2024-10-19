package com.example.notesapp.Data.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.notesapp.Data.model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun readAllData(): Flow<List<Note>>
    @Insert
     fun addNote(note: Note)
    @Update
     fun updateNote(note: Note)
    @Delete
     fun deleteNote(note: Note)
}