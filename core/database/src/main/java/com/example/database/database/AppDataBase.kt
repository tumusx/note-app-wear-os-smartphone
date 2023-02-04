package com.example.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.dao.ListNoteDao
import com.example.database.dao.NoteDao
import com.example.database.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract suspend fun noteDao(): NoteDao
    abstract suspend fun listDao(): ListNoteDao
}