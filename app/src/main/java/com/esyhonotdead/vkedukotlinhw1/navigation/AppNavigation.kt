package com.esyhonotdead.vkedukotlinhw1.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.esyhonotdead.vkedukotlinhw1.ui.screens.CardScreen
import com.esyhonotdead.vkedukotlinhw1.ui.screens.GridScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable(route = "home") {
            GridScreen(
                onCardClick = { number ->
                    navController.navigate("card/$number")
                }
            )
        }

        composable(
            route = "card/{number}",
            arguments = listOf(
                navArgument("number") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val number = backStackEntry.arguments?.getInt("number") ?: 0

            CardScreen(
                number = number,
                onClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}