package com.github.tumusx.note_list.domain.model

data class Note(
    val idNote: Long,
    val noteText: String,
    val colorNote: Int,
    val tittleNote: String,
    val lastEditor: String
)
