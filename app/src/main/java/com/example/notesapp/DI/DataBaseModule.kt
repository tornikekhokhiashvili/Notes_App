package com.example.notesapp.DI

import android.app.Application
import androidx.room.Room
import com.example.notesapp.Data.roomdb.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Provides
    @Singleton
    fun provideDataBase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            "note_database"
        ).fallbackToDestructiveMigration().build()
    }
    @Provides
    @Singleton
    fun provideNoteDao(db: NoteDatabase) = db.noteDao()
}