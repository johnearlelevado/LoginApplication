package com.example.loginapp.ui.navigation

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.loginapp.data.models.User
import com.example.loginapp.ui.screens.LoginScreen
import com.example.loginapp.ui.screens.HomeScreen

@Composable
fun LoginNavigation() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onLoginSuccess = { username, displayName ->
                    navController.navigate("home/$username/$displayName") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }
        
        composable(
            route = "home/{username}/{displayName}",
            arguments = listOf(
                navArgument("username") { type = NavType.StringType },
                navArgument("displayName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: ""
            val displayName = backStackEntry.arguments?.getString("displayName") ?: ""
            val user = User(username, displayName)
            HomeScreen(user = user)
        }
    }
}