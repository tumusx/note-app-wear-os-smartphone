package com.github.tumusx.feature_note_createupdate.presenter.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.common_design_system.ColorsBackgroundType
import com.example.common_design_system.modal.AlertCustomDialog
import com.example.common_design_system.modal.listener.AlertDialogListener
import com.example.common_extensions.fragments.callOnBackDispatcher
import com.example.common_extensions.fragments.configureBackPressedFragment
import com.github.tumusx.feature_note_createupdate.R
import com.github.tumusx.feature_note_createupdate.databinding.FragmentCreateOrUpdateNoteBinding
import com.github.tumusx.feature_note_createupdate.presenter.views.bottomSheet.OptionsNoteBottomSheet

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
        super.onViewCreated(view, savedInstanceState)
        configureBackPressedExtension()
        configureListener()
    }

    private fun configureBottomSheet() {
        val bottomSheet = OptionsNoteBottomSheet { colorsBackgroundType ->
            receiveColorConfigure(colorsBackgroundType)
        }
        bottomSheet.show(childFragmentManager, bottomSheet.tag)
    }

    private fun receiveColorConfigure(colorBackgroundType: ColorsBackgroundType) {
        binding.root.setBackgroundColor(resources.getColor(colorBackgroundType.color, null))
    }

    private fun configureListener() {
        binding.imgBackScreen.setOnClickListener { callOnBackDispatcher() }
        binding.icMoreOption.setOnClickListener {
            configureBottomSheet()
        }
    }

    private fun configureSaveChangesModal() {
        AlertDialogListener.initAlertDialogListener(object : AlertDialogListener{
            override fun discardChanges() {
                println("DESCARTANDO")
            }

            override fun saveChanges() {
                println("SALVANDO")
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