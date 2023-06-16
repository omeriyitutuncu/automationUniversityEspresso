package com.example.espresso_tau.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.espresso_tau.MyState

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun Sample(navController: NavController, state: MyState) {
    var title by remember {
        mutableStateOf("")
    }
    var newTitle by remember {
        mutableStateOf("Hello Espresso")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = state.newTitle)
        OutlinedTextField(
            value = title,
            onValueChange = { text ->
                title = text
                state.title = text
            })
        Button(onClick = {
            newTitle = title
            title = ""
            state.newTitle = state.title
            state.title = "" // todo why is not working

        }) {
            Text(text = "Change Text")
        }
        Button(onClick = {
            navController.navigate(route = Screen.Side.router)
        }) {
            Text(text = "Open activity and change text")
        }
    }

}

@Preview(showBackground = true)
@Composable()
fun SamplePreview() {
    Sample(navController = rememberNavController(), MyState())
}