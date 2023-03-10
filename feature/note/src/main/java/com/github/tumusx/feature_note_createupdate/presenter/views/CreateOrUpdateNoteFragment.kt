package com.github.tumusx.feature_note_createupdate.presenter.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.common_design_system.ColorsBackgroundType
import com.example.common_design_system.modal.AlertCustomDialog
import com.example.common_design_system.modal.listener.AlertDialogListener
import com.example.common_extensions.fragments.callOnBackDispatcher
import com.example.common_extensions.fragments.configureBackPressedFragment
import com.example.common_extensions.util.DatePattern
import com.example.common_extensions.util.customSnackBar
import com.example.common_extensions.util.getDateActual
import com.example.model.Note
import com.github.tumusx.feature_note_createupdate.R
import com.github.tumusx.feature_note_createupdate.databinding.FragmentCreateOrUpdateNoteBinding
import com.github.tumusx.feature_note_createupdate.presenter.viewModel.CreateOrUpdateNoteViewModel
import com.github.tumusx.feature_note_createupdate.presenter.viewModel.StateUi
import com.github.tumusx.feature_note_createupdate.presenter.views.bottomSheet.OptionsNoteBottomSheet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateOrUpdateNoteFragment : Fragment() {

    private lateinit var binding: FragmentCreateOrUpdateNoteBinding
    private val args by navArgs<CreateOrUpdateNoteFragmentArgs>()
    private val viewModel by viewModels<CreateOrUpdateNoteViewModel>()
    private var colorBackgroundNote: String? = null
    private var isEditingText = false
    private var isCreateNote = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCreateOrUpdateNoteBinding.inflate(layoutInflater).also { rootView ->
        binding = rootView
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureBackPressedExtension()
        configureListener()
        configureObservables()
        configureUiForUpdateNote()
        configureEditing()
    }

    private fun configureEditing() {
        binding.noteTxt.doAfterTextChanged {
            isEditingText = true
        }
    }

    private fun configureBottomSheet() {
        val bottomSheet = OptionsNoteBottomSheet { colorsBackgroundType ->
            receiveColorConfigure(colorsBackgroundType)
        }
        bottomSheet.show(childFragmentManager, bottomSheet.tag)
    }

    private fun configureObservables() {
        viewModel.uiState.observe(viewLifecycleOwner) { uiState ->
            configureUiState(uiState)
        }
    }

    private fun configureUiForUpdateNote() {
        if (args.noteVo == null) {
            isCreateNote = true
            return
        }

        args.noteVo?.let { note ->
            binding.root.setBackgroundColor(
                resources.getColor(
                    note.colorNote.toInt() ?: ColorsBackgroundType.DARK_COLOR.color.toInt(), null
                )
            )
            binding.tittleNoteTxt.setText(note.tittleNote.toString())
            binding.noteTxt.setText(note.noteText.toString())
        }
    }

    private fun configureUiState(uiState: StateUi) {

        if (uiState.messageSuccess != null) {
            binding.root.customSnackBar(
                uiState.messageSuccess.toString(),
                messageButtonDismiss = "fechar"
            )
            isEditingText = false
        }

        if (uiState.messageError != null) {
            binding.root.customSnackBar(
                uiState.messageError.toString(),
                messageButtonDismiss = "fechar"
            )
        }

    }

    private fun receiveColorConfigure(colorBackgroundType: ColorsBackgroundType) {
        binding.root.setBackgroundColor(resources.getColor(colorBackgroundType.color.toInt(), null))
        colorBackgroundNote = colorBackgroundType.color
    }

    private fun saveChangesNote() {
        viewModel.verifyUpdateOrCreateNote(
            Note(
                args.noteVo?.idNote,
                noteText = binding.noteTxt.text.toString(),
                colorNote = colorBackgroundNote ?: ColorsBackgroundType.DARK_COLOR.color,
                tittleNote = binding.tittleNoteTxt.text.toString(),
                lastEditor = toString().getDateActual(DatePattern.DATE_MONTH_YEAR.pattern)
                    .toString()
            ),
            isCreateNote
        )
    }

    private fun configureListener() {
        binding.imgBackScreen.setOnClickListener { callOnBackDispatcher() }
        binding.icMoreOption.setOnClickListener {
            configureBottomSheet()
        }
        binding.imgSaveChanges.setOnClickListener {
            saveChangesNote()
            sendNotUpdateToFragment(true)
            isEditingText = false
        }
    }

    private fun sendNotUpdateToFragment(isUpdate: Boolean = false) = requireActivity().intent.putExtra("NOT_UPDATE", isUpdate)

    private fun configureSaveChangesModal() {
        AlertDialogListener.initAlertDialogListener(object : AlertDialogListener {
            override fun discardChanges() {
                sendNotUpdateToFragment()
                findNavController().popBackStack()
            }

            override fun saveChanges() {
                saveChangesNote()
                sendNotUpdateToFragment(true)
            }
        })
    }

    private fun configureShowModalAlert() {
        if (!isEditingText) {
            findNavController().popBackStack()
        } else {
            AlertCustomDialog.Companion.newInstanceDialog(
                getString(R.string.descriptionAlert),
                getString(R.string.keep),
                getString(R.string.discard)
            ).show(childFragmentManager, AlertCustomDialog::class.java.name)
        }
    }

    private fun configureBackPressedExtension() {
        this.configureBackPressedFragment {
            configureShowModalAlert()
            configureSaveChangesModal()
        }
    }
}