package com.example.notesapp.DI

import com.example.notesapp.Domain.repository.NoteRepository
import com.example.notesapp.Data.repository.NoteRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun binNoteRepository(
        noteRepositoryImpl: NoteRepositoryImp
    ): NoteRepository
}