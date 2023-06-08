package com.example.espresso_tau

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.espresso_tau.pages.Sample
import com.example.espresso_tau.pages.SetupNavGraph
import com.example.espresso_tau.ui.theme.Espresso_TAUTheme

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Espresso_TAUTheme {
               navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}





@Composable
fun Greetings(name: String) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color.Red)
            .fillMaxSize()
    ) {
        Text(
            text = "isim $name",
            color = Color.Blue,
            fontSize = 30.sp,
            modifier = Modifier.fillMaxSize()
        )

        Text(
            text = "okkess mahmut gil oglu",
            color = Color.Black,
            fontSize = 30.sp
        )
    }


}


@Composable
fun ClickText(title: String, modifier: Modifier = Modifier, onClick: () -> Unit) {

}

@Composable
fun OpenActivity(title: String) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Espresso_TAUTheme {
        Sample(navController = rememberNavController())
    }
}



