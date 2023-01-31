package com.github.tumusx.feature_note_createupdate.presenter.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.common_extensions.fragments.callOnBackDispatcher
import com.example.common_extensions.fragments.configureBackPressedFragment
import com.github.tumusx.feature_note_createupdate.databinding.FragmentCreateOrUpdateNoteBinding
import com.google.android.material.snackbar.Snackbar

class CreateOrUpdateNoteFragment : Fragment() {

    private lateinit var binding: FragmentCreateOrUpdateNoteBinding
    private val args by navArgs<CreateOrUpdateNoteFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCreateOrUpdateNoteBinding.inflate(layoutInflater).also { rootView ->
        binding = rootView
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.noteTxt.setText(args.noteNav.nameNome)
        super.onViewCreated(view, savedInstanceState)
        //configureBackPressedExtension()
        configureListener()
    }

    private fun configureListener() {

    }

    private fun configureBackPressedExtension() {
        this.configureBackPressedFragment {
            Snackbar.make(binding.root, "calling", Snackbar.LENGTH_LONG).show()
        }
    }
}