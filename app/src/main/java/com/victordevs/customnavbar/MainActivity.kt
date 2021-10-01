package com.victordevs.customnavbar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import com.victordevs.customnavbar.ui.custom_nav.CustomBottomNavigation
import com.victordevs.customnavbar.ui.custom_nav.Screens
import com.victordevs.customnavbar.ui.theme.CustomNavBarTheme
import java.lang.reflect.Modifier

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomNavBarTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                   BottomNavBar()
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@ExperimentalAnimationApi
@Composable
fun BottomNavBar() {
    val currentScreen = mutableStateOf<Screens>(Screens.Home)
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            bottomBar = {
                CustomBottomNavigation(currentScreenId = currentScreen.value.id) {
                    currentScreen.value = it
                }
            }
        ) {

        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CustomNavBarTheme {
        BottomNavBar()
    }
}