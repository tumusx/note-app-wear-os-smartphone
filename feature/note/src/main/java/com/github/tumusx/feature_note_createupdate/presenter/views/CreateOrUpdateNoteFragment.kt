package com.github.tumusx.feature_note_createupdate.presenter.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
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
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CreateOrUpdateNoteFragment : Fragment() {

    private lateinit var binding: FragmentCreateOrUpdateNoteBinding
    private val args by navArgs<CreateOrUpdateNoteFragmentArgs>()
    private val viewModel by viewModels<CreateOrUpdateNoteViewModel>()
    private var colorBackgroundNote: Int? = null

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

    private fun configureUiState(uiState: StateUi) {

        if (uiState.messageSuccess != null) {
            binding.root.customSnackBar(
                uiState.messageSuccess.toString(),
                messageButtonDismiss = "fechar"
            )
        }

        if (uiState.messageError != null) {
            binding.root.customSnackBar(
                uiState.messageError.toString(),
                messageButtonDismiss = "fechar"
            )
        }

    }

    private fun receiveColorConfigure(colorBackgroundType: ColorsBackgroundType) {
        binding.root.setBackgroundColor(resources.getColor(colorBackgroundType.color, null))
        colorBackgroundNote = colorBackgroundType.color
    }

    private fun saveChangesNote() {
        viewModel.createNote(
            Note(
                noteText = binding.noteTxt.text.toString(),
                colorNote = colorBackgroundNote ?: ColorsBackgroundType.DARK_COLOR.color,
                tittleNote = binding.tittleNoteTxt.text.toString(),
                lastEditor = toString().getDateActual(DatePattern.DATE_MONTH_YEAR.pattern)
                    .toString()
            )
        )
    }

    private fun configureListener() {
        binding.imgBackScreen.setOnClickListener { callOnBackDispatcher() }
        binding.icMoreOption.setOnClickListener {
            configureBottomSheet()
        }
        binding.imgSaveChanges.setOnClickListener {
            saveChangesNote()
        }
    }

    private fun configureSaveChangesModal() {
        AlertDialogListener.initAlertDialogListener(object : AlertDialogListener {
            override fun discardChanges() {
                this@CreateOrUpdateNoteFragment.exitTransition
            }

            override fun saveChanges() {
                saveChangesNote()
            }
        })
    }

    private fun configureShowModalAlert() {
        AlertCustomDialog.Companion.newInstanceDialog(
            getString(R.string.descriptionAlert),
            getString(R.string.keep),
            getString(R.string.discard)
        ).show(childFragmentManager, AlertCustomDialog::class.java.name)
    }

    private fun configureBackPressedExtension() {
        this.configureBackPressedFragment {
            configureShowModalAlert()
            configureSaveChangesModal()
        }
    }
}