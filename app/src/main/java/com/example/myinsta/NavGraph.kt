package com.example.myinsta

import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
){
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable(
            route = Screen.Login.route
        ){
            LoginScreen(navController = navController)
        }
        composable(
            route = Screen.SignUp.route
        ){
            SignUpScreen(navController = navController)
        }
        composable(
            route = Screen.Bottom.route
        ){
            BottomNavigationBar()
        }
        composable(
            route = BottomBarScreen.Profile.route
        ){
            ProfileScreen(navController = navController)
        }
        composable(
            route = BottomBarScreen.Notification.route
        ){
            NotificationScreen(navController = navController)
        }
        composable(
            route = BottomBarScreen.Search.route
        ){
            SearchScreen(navController = navController)
        }
        composable(
            route = BottomBarScreen.Home.route
        ){
            HomeScreen(navController = navController)
        }

    }
}