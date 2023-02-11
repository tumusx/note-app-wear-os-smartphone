package com.github.tumusx.note_list.presenter.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.model.Note
import com.github.tumusx.core_navigation.route.customNavigation
import com.github.tumusx.feature_note_list.databinding.FragmentListNotesBinding
import com.github.tumusx.note_list.presenter.adapter.ListNoteAdapter
import com.github.tumusx.note_list.presenter.viewModel.ListNoteStateUI
import com.github.tumusx.note_list.presenter.viewModel.ListNoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListNotesFragment : Fragment() {

    private lateinit var binding: FragmentListNotesBinding
    private val viewModel by viewModels<ListNoteViewModel>()
    private var noteAdapter: ListNoteAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentListNotesBinding.inflate(layoutInflater).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navToCreateItem()
        configureObservables()
    }

    private fun navToCreateItem() = binding.fbButton.setOnClickListener {
        customNavigation(ListNotesFragmentDirections.actionToCreateNote(null))
    }

    private fun configureNavigation(note: Note) {
        customNavigation(ListNotesFragmentDirections.actionToCreateNote(note))
    }

    private fun configureRecyclerView(listItems: List<Note>) {
        binding.rvListNote.visibility = View.VISIBLE
        binding.llEmptyList.visibility = View.GONE
        noteAdapter = ListNoteAdapter {
            configureNavigation(it)
        }
        noteAdapter?.updateList(listItems)
        binding.rvListNote.adapter = noteAdapter

    }

    private fun configureStateUi(stateUI: ListNoteStateUI) {
        if (stateUI.success?.isNotEmpty() == true) {
            stateUI.success?.let { configureRecyclerView(it) }
            return
        }

        if (stateUI.isLoading) {
            return
        }

        if (stateUI.error != null) {
            return
        }

    }

    private fun configureObservables() {
        lifecycleScope.launch {
            viewModel.noteState.collect {
                configureStateUi(it)
            }
        }
    }

}