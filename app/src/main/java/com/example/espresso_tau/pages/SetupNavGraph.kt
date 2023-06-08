package com.example.espresso_tau.pages

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.espresso_tau.MyState

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.router
    ) {


        composable(
            route = Screen.Home.router
        ) {
             Sample(navController = navController)
        }

        composable(
            route = Screen.Side.router
        ) {
            SideScreen(navController = navController)
        }

    }
}