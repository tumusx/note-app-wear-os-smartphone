package com.example.common_extensions.util

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.customSnackBar(message: String, messageButtonDismiss: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).also { snackBar ->
        snackBar.setAction(messageButtonDismiss) {
            snackBar.dismiss()
        }
    }.show()
}
