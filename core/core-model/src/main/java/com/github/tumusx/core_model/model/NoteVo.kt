package com.github.tumusx.core_model.model

data class NoteVo(
    val nameNote: String,
    val idNote: Long,
    val tagTypeNote: String,
    val noteText: String,
    val colorNote: Int,
    val fontColorTextNote: Int,
    val fontColorTittleNote: Int,
    val tittleNote: String,
    val lastEditor: String

)
