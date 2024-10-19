package com.example.notesapp.Domain.usecase

import com.example.notesapp.Data.model.Note
import com.example.notesapp.Domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddNoteUseCase@Inject constructor(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke (note: Note) = withContext(Dispatchers.IO) {
         noteRepository.addNote(note)
    }
}