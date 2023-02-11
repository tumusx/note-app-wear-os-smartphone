package com.example.common_design_system.modal

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.common_design_system.modal.listener.AlertDialogListener
import com.github.tumusx.common_design_system.R
import com.github.tumusx.common_design_system.databinding.ModalAlertSaveChangesBinding

class AlertCustomDialog : DialogFragment() {

    private lateinit var binding: ModalAlertSaveChangesBinding
    private var descriptionText: String? = null
    private var textButtonSaveChanges: String? = null
    private var textButtonDiscardChanges: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ModalAlertSaveChangesBinding.inflate(layoutInflater).also { root ->
        binding = root
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        configureUiModal()
        configureListener()
        configureBackgroundColorBottomSheet()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun configureBackgroundColorBottomSheet() =
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


    private fun configureUiModal() {
        this.isCancelable = false
        binding.btnSaveChangesOk.text = textButtonSaveChanges ?: ""
        binding.btnCancelSaveChanges.text = textButtonDiscardChanges ?: ""
        binding.txtDescriptionDiscardChanges.text = descriptionText ?: ""
    }

    private fun configureListener() {
        binding.btnSaveChangesOk.setOnClickListener {
            AlertDialogListener.alertDialog.saveChanges()
            this.dismiss()
        }
        binding.btnCancelSaveChanges.setOnClickListener {
            AlertDialogListener.alertDialog.discardChanges()
            this.dismiss()
        }
    }


    companion object {
        fun newInstanceDialog(
            description: String,
            textSaveChanges: String,
            textCancelChanges: String,
        ): AlertCustomDialog {
            val alertCustomDialog = AlertCustomDialog()
            alertCustomDialog.descriptionText = description
            alertCustomDialog.textButtonDiscardChanges = textCancelChanges
            alertCustomDialog.textButtonSaveChanges = textSaveChanges
            return alertCustomDialog
        }
    }
}