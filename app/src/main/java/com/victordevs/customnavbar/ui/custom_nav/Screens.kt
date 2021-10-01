package com.victordevs.customnavbar.ui.custom_nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

// Created by Victor Hernandez on 1/10/21.
// Proyect Custom NavBar
//contact victoralfonso920@gmail.com

sealed class Screens(
    val id:String,
    val title:String,
    val icon:ImageVector
) {


    object Home : Screens("home", "Home", Icons.Outlined.Home)
    object Search : Screens("search", "Search", Icons.Outlined.Search)
    object Profile : Screens("profile", "Profile", Icons.Outlined.Person)
    object Settings : Screens("settings", "Settings", Icons.Outlined.Settings)


    object Items {
        val list = listOf(
            Home, Search, Profile, Settings
        )
    }
}