package com.example.myinsta

sealed class Screen(val route: String) {
    object Login: Screen(route = "login_screen")
    object SignUp: Screen(route = "signup_screen")
    object Profile: Screen(route = "profile_screen")
    object  Bottom: Screen(route = "bottom_screen")
}
