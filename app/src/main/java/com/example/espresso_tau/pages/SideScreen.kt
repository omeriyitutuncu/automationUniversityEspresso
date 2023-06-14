package com.example.espresso_tau.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.espresso_tau.MyState

@Composable
fun SideScreen(navController: NavController, title:String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

     //  val state: MyState? by  navController .previousBackStackEntry?.savedStateHandle?.getLiveData<MyState>("state").obser
            Text(
                text = "ddd $title",//+ state?.newTitle, //todo how to pass data
                fontSize = 30.sp
            )
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "back")
        }
    }

}