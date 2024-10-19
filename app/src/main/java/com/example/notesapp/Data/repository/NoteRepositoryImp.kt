package com.example.notesapp.Data.repository

import com.example.notesapp.Data.model.Note
import com.example.notesapp.Domain.repository.NoteRepository
import com.example.notesapp.Data.roomdb.NoteDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoryImp @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository {
    override suspend fun readAllData(): Flow<List<Note>> {
        return noteDao.readAllData()
    }
    override suspend fun addNote(note: Note) {
        noteDao.addNote(note)
    }
    override suspend fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }
    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }
}