package com.github.tumusx.note_list.presenter.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.tumusx.core_navigation.model.NoteNavVO
import com.github.tumusx.core_navigation.route.customNavigation
import com.github.tumusx.feature_note_list.databinding.FragmentListNotesBinding

class ListNotesFragment : Fragment() {

    private lateinit var binding: FragmentListNotesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentListNotesBinding.inflate(layoutInflater).also {
        binding = it
    }.root
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navToCreateItem()
    }
    private fun navToCreateItem() = binding.fbButton.setOnClickListener {
        customNavigation(ListNotesFragmentDirections.actionToCreateNote(NoteNavVO("Murillo")))
    }

}