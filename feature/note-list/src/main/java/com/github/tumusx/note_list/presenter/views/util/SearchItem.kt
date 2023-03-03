package com.github.tumusx.note_list.presenter.views.util

import com.example.model.Note
import javax.security.auth.callback.Callback

fun searchItem(queryItem: String, listItem: List<Note>) : List<Note>{
    val addItemInList = mutableListOf<Note>()
    for (item in listItem) {
        if (queryItem.contains(item.tittleNote.toString())) {
            addItemInList.add(item)
            return addItemInList
        }
    }
    return emptyList()
}