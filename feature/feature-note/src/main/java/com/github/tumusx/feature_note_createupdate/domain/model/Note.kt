package com.github.tumusx.feature_note_createupdate.domain.model

data class Note(
    val idNote: Long,
    val noteText: String,
    val colorNote: Int,
    val tittleNote: String,
    val lastEditor: String
)