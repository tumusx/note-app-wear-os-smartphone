package com.github.tumusx.note_list.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.tumusx.core_model.model.NoteVo
import com.github.tumusx.feature_note_list.databinding.ContainerItemsNoteBinding

class ListNoteAdapter : RecyclerView.Adapter<ListNoteAdapter.ListNoteViewHolder>() {
    private val noteListItems = emptyList<NoteVo>()

    class ListNoteViewHolder(private val binding: ContainerItemsNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun configUi(noteVo: NoteVo) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ListNoteViewHolder(
        ContainerItemsNoteBinding.inflate(LayoutInflater.from(parent.context))
    )

    override fun getItemCount() = noteListItems.size

    override fun onBindViewHolder(holder: ListNoteViewHolder, position: Int) =
        holder.configUi(noteListItems[position])

}