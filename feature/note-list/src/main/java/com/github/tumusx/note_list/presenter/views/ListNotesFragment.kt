package com.github.tumusx.note_list.presenter.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.model.Note
import com.github.tumusx.core_navigation.route.customNavigation
import com.github.tumusx.feature_note_list.databinding.FragmentListNotesBinding
import com.github.tumusx.note_list.presenter.adapter.ListNoteAdapter
import com.github.tumusx.note_list.presenter.viewModel.ListNoteStateUI
import com.github.tumusx.note_list.presenter.viewModel.ListNoteViewModel
import com.github.tumusx.note_list.presenter.views.util.searchItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListNotesFragment : Fragment() {

    private lateinit var binding: FragmentListNotesBinding
    private val viewModel by viewModels<ListNoteViewModel>()
    private var noteAdapter: ListNoteAdapter? = null
    private var noteList: List<Note>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentListNotesBinding.inflate(layoutInflater).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navToCreateItem()
        configureSearchItemView()
        configureObservables()
    }

    private fun updateListBySearch(querys: String?) {
        if (querys.isNullOrEmpty()) return

        noteList?.let { listNote ->
            val resultItem = searchItem(querys, listNote)
                if (resultItem.isNotEmpty()) {
                    noteAdapter?.updateList(listNote)
                }
        }
    }

    private fun configureSearchItemView() {
        binding.searchItem.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(querys: String?): Boolean {
                updateListBySearch(querys)
                return false
            }

            override fun onQueryTextChange(querys: String?): Boolean {
                updateListBySearch(querys)
                return false
            }
        })
    }

    private fun configureUpdateList(isNotUpdate: Boolean) {
        if (isNotUpdate) {
            viewModel.allListNote()
        }
    }

    private fun isUpdateListNote() =
        requireActivity().intent.getBooleanExtra("NOT_UPDATE", true).also { isUpdate ->
            configureUpdateList(!isUpdate)
        }

    override fun onResume() {
        isUpdateListNote()
        super.onResume()
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
            noteList = stateUI.success
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
        viewModel.noteState.observe(viewLifecycleOwner) {
            configureStateUi(it)
        }
    }

}