package com.github.tumusx.note_list.presenter.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.github.tumusx.core_navigation.route.customNavigation
import com.github.tumusx.feature_note_list.databinding.FragmentListNotesBinding
import com.github.tumusx.note_list.presenter.viewModel.ListNoteStateUI
import com.github.tumusx.note_list.presenter.viewModel.ListNoteViewModel
import kotlinx.coroutines.launch

class ListNotesFragment : Fragment() {

    private lateinit var binding: FragmentListNotesBinding
    private val viewModel by viewModels<ListNoteViewModel>()

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

    private fun configureStateUi(stateUI: ListNoteStateUI) {
        if (stateUI.success?.isNotEmpty() == true) {

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
            viewModel.noteState.collect{
                configureStateUi(it)
            }
        }
    }

}