package com.example.espresso_tau.pages

sealed class Screen(val router: String) {
    object Home : Screen("home_screen")
    object Side : Screen("side_screen")
}
