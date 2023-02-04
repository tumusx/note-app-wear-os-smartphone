package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.example.database.entity.NoteEntity


@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(vararg noteItem: NoteEntity)

    @Update
    suspend fun alterNote(vararg noteItem: NoteEntity)


}