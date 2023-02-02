package com.github.tumusx.core_data.local.database

import com.github.tumusx.core_data.local.dao.ListNoteDao
import com.github.tumusx.core_data.local.dao.NoteDao

abstract class NoteDataBase {
    abstract fun listNoteDao() : ListNoteDao
    abstract fun noteDao() : NoteDao
}