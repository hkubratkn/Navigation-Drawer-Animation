package com.kapirti.zikirmatik

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kapirti.zikirmatik.screens.CounterScreenCompos
import com.kapirti.zikirmatik.screens.LibraryScreenCompos

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            CounterScreenCompos()
        }
        composable(route = BottomBarScreen.Librry.route) {
            LibraryScreenCompos()
        }
    }
}