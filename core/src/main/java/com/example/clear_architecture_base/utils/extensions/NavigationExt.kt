package com.example.clear_architecture_base.utils.extensions

import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.navigation.NavController

fun NavController.setStartDestination(
    @NavigationRes navParentId: Int,
    @IdRes startDestinationId: Int
) {
    graph = navInflater.inflate(navParentId).apply { setStartDestination(startDestinationId) }
}
