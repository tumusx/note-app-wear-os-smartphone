package com.github.tumusx.core_navigation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NoteNavVO(
    var idNote: Long? = null,
    val noteText: String?,
    val colorNote: String,
    val tittleNote: String?,
    val lastEditor: String?
) : Parcelable
