package com.example.myinsta

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val icon: ImageVector
){
    object Home : BottomBarScreen(
        route = "home",
        icon = Icons.Default.Home
    )
    object Search : BottomBarScreen(
        route = "search",
        icon = Icons.Default.Search
    )
    object Notification : BottomBarScreen(
        route = "notification",
        icon = Icons.Default.Favorite
    )
    object Profile : BottomBarScreen(
        route = "profile",
        icon = Icons.Default.Person
    )
}
