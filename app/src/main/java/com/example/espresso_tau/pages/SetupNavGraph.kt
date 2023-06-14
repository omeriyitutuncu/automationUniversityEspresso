package com.example.espresso_tau.pages

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.espresso_tau.MyState
import kotlinx.coroutines.channels.ticker

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.router
    ) {


        composable(
            route = Screen.Home.router,
            arguments = listOf(
                navArgument("title") {
                    type = NavType.StringType
                }
            )
        ) {
            Sample(navController = navController)
        }

        composable(
            route = Screen.Side.router
        ) {

            val title = it.arguments?.getString("title") ?: ""
            SideScreen(navController = navController, title = "$title from argument")
        }

    }
}