package com.github.tumusx.core_navigation.route

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController


fun Fragment.customNavigation(idResourceNavigate: NavDirections) {
    this.findNavController().navigate(idResourceNavigate)
}