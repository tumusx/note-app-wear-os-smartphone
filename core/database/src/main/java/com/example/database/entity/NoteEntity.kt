package com.example.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteEntity(
    @PrimaryKey
    var idNote: Long? = null,

    @ColumnInfo(name = "note_text")
    val noteText: String,

    @ColumnInfo(name = "color_note")
    val colorNote: Int,

    @ColumnInfo(name = "tittle_name")
    val tittleNote: String,

    @ColumnInfo(name = "last_editor")
    val lastEditor: String
)