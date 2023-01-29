package com.github.tumusx.core_model.mapper

import com.github.tumusx.core_model.model.NoteDTO
import com.github.tumusx.core_model.model.NoteVo

fun NoteDTO.noteVO(): NoteVo {
    return NoteVo(
        this.nameNote,
        this.idNote,
        this.tagTypeNote,
        this.noteText,
        this.colorNote,
        this.fontColorTextNote,
        this.fontColorTittleNote,
        this.tittleNote,
        this.lastEditor

    )
}

fun NoteVo.noteDTO(): NoteDTO {
    return NoteDTO(
        this.nameNote,
        this.idNote,
        this.tagTypeNote,
        this.noteText,
        this.colorNote,
        this.fontColorTextNote,
        this.fontColorTittleNote,
        this.tittleNote,
        this.lastEditor
    )
}


