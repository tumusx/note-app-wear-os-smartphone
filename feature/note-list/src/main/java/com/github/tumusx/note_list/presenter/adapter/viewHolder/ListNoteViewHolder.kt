package com.github.tumusx.note_list.presenter.adapter.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.model.Note
import com.github.tumusx.feature_note_list.databinding.ContainerItemsNoteBinding

class ListNoteViewHolder(val binding: ContainerItemsNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun configUi(noteVo: Note) {
            binding.txtTittleNote.text = noteVo.tittleNote
            binding.txtNote.text = noteVo.noteText
        }
    }