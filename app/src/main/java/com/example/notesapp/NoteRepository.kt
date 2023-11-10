package com.example.notesapp

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {

    val readAllData: LiveData<List<Note>> = noteDao.getAll()

     suspend fun addNote(note: Note) {
        noteDao.insert(note)
    }

     suspend fun updateNote(note: Note) {
        noteDao.update(note)
    }

     suspend fun deleteNote(note: Note) {
        noteDao.delete(note)
    }
}