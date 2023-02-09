package com.example.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.dao.ListNoteDao
import com.example.database.dao.NoteDao
import com.example.database.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract  fun listDao(): ListNoteDao
}