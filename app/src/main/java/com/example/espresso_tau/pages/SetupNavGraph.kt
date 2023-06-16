package com.example.espresso_tau.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.espresso_tau.MyState

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    val state by remember {
        mutableStateOf(MyState())
    }
    NavHost(
        navController = navController,
        startDestination = Screen.Home.router
    ) {
        composable(
            route = Screen.Home.router
        ) {
            Sample(navController = navController, state)
        }

        composable(
            route = Screen.Side.router
        ) {
            SideScreen(navController = navController, title = "${state.newTitle} from argument")
        }
    }
}