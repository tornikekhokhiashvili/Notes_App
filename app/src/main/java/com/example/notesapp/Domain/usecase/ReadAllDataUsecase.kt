package com.example.notesapp.Domain.usecase

import com.example.notesapp.Domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReadAllDataUsecase@Inject constructor(
    private val noteRepository: NoteRepository
){
    suspend operator fun invoke()= withContext(Dispatchers.IO){
        noteRepository.readAllData()
    }
}