package com.esyhonotdead.vkedukotlinhw1.navigation

sealed class Screen(val route: String) {
    data object Grid : Screen("grid")
    data object Card : Screen("card")
}