package com.github.tumusx.note_list.presenter.views.util

import com.example.model.Note
import javax.security.auth.callback.Callback

fun searchItemInList(queryItem: String, listItem: List<Note>, resultCallback: (List<Note>) -> Unit){
    listItem.forEach { noteItem->
        if(noteItem.noteText.toString().contains(queryItem)){
            resultCallback.invoke(listOf(noteItem))
        }else{
            resultCallback.invoke(emptyList())
        }
    }
}