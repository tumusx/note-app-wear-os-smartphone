package com.github.tumusx.note_list.presenter.adapter.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.example.model.Note

class NoteDiffUtil(private val oldItem: List<Note>, private val newItem: List<Note>) :
            DiffUtil.Callback() {
            override fun getOldListSize() = oldItem.size

            override fun getNewListSize() = newItem.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                oldItem[oldItemPosition].idNote == newItem[newItemPosition].idNote

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                oldItem[oldItemPosition] == newItem[newItemPosition]
        }