package com.example.notesapp.Presentation.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.Data.model.Note
import com.example.notesapp.Domain.usecase.AddNoteUseCase
import com.example.notesapp.Domain.usecase.DeleteNoteUsecase
import com.example.notesapp.Domain.usecase.ReadAllDataUsecase
import com.example.notesapp.Domain.usecase.UpdateNoteUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteNoteUsecase: DeleteNoteUsecase,
    private val updateNoteUseCase: UpdateNoteUsecase,
    private val readAllDataUsecase: ReadAllDataUsecase
) : ViewModel() {
    private val _noteList: MutableStateFlow<List<Note>> = MutableStateFlow(emptyList())
    val noteList: StateFlow<List<Note>> get() = _noteList.asStateFlow()
    init {
        fetchNotes()
    }
    private fun fetchNotes() {
        viewModelScope.launch {
            readAllDataUsecase().collect{
                _noteList.value = it
            }
        }
    }

    fun addNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            addNoteUseCase(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            updateNoteUseCase(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteNoteUsecase(note)
        }
    }
}