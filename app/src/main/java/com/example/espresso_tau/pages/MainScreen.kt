package com.example.espresso_tau.pages

import android.util.Log
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
fun Sample(navController: NavController){
    var title by remember {
        mutableStateOf("")
    }
    var newTitle by remember {
        mutableStateOf("Hello Espresso")
    }
    val state by remember {
        mutableStateOf(MyState())
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Log.e("omer", "start is ${state.newTitle} and state title is ${state.title}")
newTitle //todo newTitle needs to be removed
        Text(text =  state.newTitle )
        OutlinedTextField(
            value = title,
            onValueChange = { text ->
                title = text
                state.title =text

               // Log.e("omer", "text is $text and state title is ${state.title}")
            })
        Button(onClick = {
          //  Log.e("omer", "before is ${state.newTitle} and state title is ${state.title}")
            newTitle = title
            title=""
            state.newTitle = state.title
            state.title="" // todo why is not working
            //Log.e("omer", "after is ${state.newTitle} and state title is ${state.title}")
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
    Sample(navController = rememberNavController())
}