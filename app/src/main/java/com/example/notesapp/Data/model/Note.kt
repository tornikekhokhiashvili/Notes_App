package com.example.notesapp.Data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name = "note") val note: String,
    @ColumnInfo(name = "date") val date: String
):Parcelable
