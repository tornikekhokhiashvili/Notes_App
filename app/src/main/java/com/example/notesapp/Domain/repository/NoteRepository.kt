package com.example.notesapp.Domain.repository

import com.example.notesapp.Data.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun readAllData(): Flow<List<Note>>
    suspend fun addNote(note: Note)
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(note: Note)
}