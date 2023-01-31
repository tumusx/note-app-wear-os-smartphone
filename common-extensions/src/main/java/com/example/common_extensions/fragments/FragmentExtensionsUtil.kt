package com.example.common_extensions.fragments

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

fun Fragment.configureBackPressedFragment(callback: () -> Unit) {
    this.requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            callback.invoke()
        }
    })
}

fun Fragment.callOnBackDispatcher() {
    this.requireActivity().onBackPressedDispatcher.onBackPressed()
}