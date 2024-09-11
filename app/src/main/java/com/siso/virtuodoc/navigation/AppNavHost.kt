package com.siso.virtuodoc.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.siso.virtuodoc.ui.theme.screens.appointments.BookAppointmentScreen
import com.siso.virtuodoc.ui.theme.screens.appointments.ViewAppointmentScreen
import com.siso.virtuodoc.ui.theme.screens.home.HomeScreen
import com.siso.virtuodoc.ui.theme.screens.login.LoginScreen
import com.siso.virtuodoc.ui.theme.screens.register.RegisterScreen
import com.siso.virtuodoc.ui.theme.screens.splash.SplashScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController= rememberNavController(), startDestination: String= ROUTE_SPLASH) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUTE_LOGIN){
            LoginScreen(navController)

        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)

        }
        composable(ROUTE_HOME){
            HomeScreen(navController)

        }
        composable(ROUTE_DOCTOR){


        }
        composable(ROUTE_BOOK_APPOINTMENT){
            BookAppointmentScreen(navController)

        }
        composable(ROUTE_VIEW_APPOINTMENT){
            ViewAppointmentScreen(navController)


        }
        composable(ROUTE_PHARMACIES){

        }
        composable(ROUTE_LABS){

        }

    }
}


