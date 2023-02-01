package com.example.common_design_system.modal.listener

interface AlertDialogListener {
    fun discardChanges()
    fun saveChanges()

    companion object {
        lateinit var alertDialog: AlertDialogListener
        fun initAlertDialogListener(alertDialogListener: AlertDialogListener) {
            alertDialog = alertDialogListener
        }
    }
}