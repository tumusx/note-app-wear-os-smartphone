package com.github.tumusx.note_list.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Note
import com.github.tumusx.feature_note_list.databinding.ContainerItemsNoteBinding
import com.github.tumusx.note_list.presenter.adapter.diffutil.NoteDiffUtil
import com.github.tumusx.note_list.presenter.adapter.viewHolder.ListNoteViewHolder

class ListNoteAdapter(private val selectItem: (Note) -> Unit) :
    RecyclerView.Adapter<ListNoteViewHolder>() {
    private var noteListItems = emptyList<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ListNoteViewHolder(
        ContainerItemsNoteBinding.inflate(LayoutInflater.from(parent.context))
    )

    fun updateList(newList: List<Note>) {
        DiffUtil.calculateDiff(NoteDiffUtil(noteListItems, newList)).also {
            it.dispatchUpdatesTo(this@ListNoteAdapter)
        }
        noteListItems = newList
    }

    override fun getItemCount() = noteListItems.size

    private fun configureListenerItems(binding: ContainerItemsNoteBinding, noteItem: Note) {
        binding.root.setOnClickListener {
            selectItem.invoke(noteItem)
        }
    }

    override fun onBindViewHolder(holder: ListNoteViewHolder, position: Int) {
        holder.configUi(noteListItems[position])
        configureListenerItems(holder.binding, noteListItems[position])
    }
}