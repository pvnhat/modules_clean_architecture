package com.example.clear_architecture_base.utils.extensions

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

fun Fragment.findNavControllerSafely(): NavController? {
    return if (isAdded) {
        findNavController()
    } else {
        null
    }
}
