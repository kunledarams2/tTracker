package com.e.ttracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.e.ttracker.ui.theme.TTrackerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SetComposeView()
//                    Greeting("Android")
//                    HeaderView()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun SetComposeView() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {

            BottomNavigationBar(navController)
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,

        floatingActionButton = {

            FloatingActionButton(
                shape = CircleShape,
                onClick = { }, backgroundColor = Color(0XFF34A853)
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription ="" , tint = Color.White )
            }
        },


        content = {
            MNavigation(navController)

        })

}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Search,
        NavigationItem.Notification,
        NavigationItem.Setting
    )

    Card(
//        shape = RoundedCornerShape(topEnd = 18f, topStart = 18f),

        elevation = 20.dp,

        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()

    ) {
        BottomNavigation(
            backgroundColor = Color.White,
            contentColor = Color(0xFF1E1F4B)
        ) {
            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            fontFamily = FontFamily(Font(R.font.poppins_light))
                        )
                    },
                    selectedContentColor = Color(0xFF34A853),
                    unselectedContentColor = Color(0xFF1E1F4B),
                    alwaysShowLabel = true,
                    selected = false,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }

                    })


            }

        }
    }


}

@Composable
fun MNavigation(navController: NavHostController/*, navigateToPlayer: () -> Unit*/) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {

            HeaderView()

        }
        composable(NavigationItem.Search.route) {
//            SearchScreen()
        }

        composable(NavigationItem.Notification.route) {
//            SearchScreen()
        }

        composable(NavigationItem.Setting.route) {
//            SearchScreen()
        }
    }
}


@Composable
fun DefaultPreview() {
    TTrackerTheme {

    }
}