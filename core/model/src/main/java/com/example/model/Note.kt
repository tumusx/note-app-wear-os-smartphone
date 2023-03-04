package com.example.model

data class Note(
    var idNote: Long? = null,
    val noteText: String?,
    val colorNote: String,
    val tittleNote: String?,
    val lastEditor: String?
) : java.io.Serializable
