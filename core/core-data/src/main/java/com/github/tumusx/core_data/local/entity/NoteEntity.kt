package com.github.tumusx.core_data.local.entity

data class NoteEntity(
    val idNote: Long,
    val noteText: String,
    val colorNote: Int,
    val tittleNote: String,
    val lastEditor: String
)